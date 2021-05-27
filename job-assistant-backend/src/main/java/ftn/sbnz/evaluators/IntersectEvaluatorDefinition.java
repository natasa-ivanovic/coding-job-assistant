package ftn.sbnz.evaluators;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Collections;

import org.drools.core.base.BaseEvaluator;
import org.drools.core.base.ValueType;
import org.drools.core.base.evaluators.EvaluatorCache;
import org.drools.core.base.evaluators.EvaluatorDefinition;
import org.drools.core.base.evaluators.Operator;
import org.drools.core.common.InternalFactHandle;
import org.drools.core.common.InternalWorkingMemory;
import org.drools.core.rule.VariableRestriction.ObjectVariableContextEntry;
import org.drools.core.rule.VariableRestriction.VariableContextEntry;
import org.drools.core.spi.Evaluator;
import org.drools.core.spi.FieldValue;
import org.drools.core.spi.InternalReadAccessor;

public class IntersectEvaluatorDefinition implements EvaluatorDefinition {
	public static final Operator INTERSECT_COMPARE = Operator.addOperatorToRegistry("intersects", false);
	public static final Operator NOT_INTERSECT_COMPARE = Operator.addOperatorToRegistry("intersects", true);
	private static final String[] SUPPORTED_IDS = { INTERSECT_COMPARE.getOperatorString() };

	public enum Operations {
		withAtLeastOne;
	}

	private Evaluator[] evaluator;

	private EvaluatorCache evaluators = new EvaluatorCache() {
		private static final long serialVersionUID = 510l;
		{
			addEvaluator(ValueType.OBJECT_TYPE, INTERSECT_COMPARE, IntersectEvaluator.INSTANCE);
			addEvaluator(ValueType.OBJECT_TYPE, NOT_INTERSECT_COMPARE, NonIntersectEvaluator.INSTANCE);
		}
	};

	@Override
	public Evaluator getEvaluator(ValueType type, Operator operator) {
		return this.getEvaluator(type, operator.getOperatorString(), operator.isNegated(), null);
	}

	@Override
	public Evaluator getEvaluator(ValueType type, Operator operator, String parameterText) {
		return this.getEvaluator(type, operator.getOperatorString(), operator.isNegated(), parameterText);
	}

	@Override
	public Evaluator getEvaluator(ValueType type, String operatorId, boolean isNegated, String parameterText) {
		return getEvaluator(type, operatorId, isNegated, parameterText, Target.FACT, Target.FACT);
	}

	@Override
	public Evaluator getEvaluator(ValueType type, String operatorId, boolean isNegated, String parameterText,
			Target leftTarget, Target rightTarget) {
		return this.evaluators.getEvaluator(type, Operator.determineOperator(operatorId, isNegated));
	}

	@Override
	public String[] getEvaluatorIds() {
		return SUPPORTED_IDS;
	}

	@Override
	public Target getTarget() {
		return Target.FACT;
	}

	@Override
	public boolean isNegatable() {
		return true;
	}

	@Override
	public boolean supportsType(ValueType type) {
		return this.evaluators.supportsType(type);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		evaluator = (Evaluator[]) in.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(evaluator);
	}

	public static class IntersectEvaluator extends BaseEvaluator {
		public final static Evaluator INSTANCE = new IntersectEvaluator();

		public IntersectEvaluator() {
			super(ValueType.OBJECT_TYPE, INTERSECT_COMPARE);
		}

		public boolean evaluate(InternalWorkingMemory workingMemory, InternalReadAccessor extractor, Object object,
				FieldValue value) {
			Collection valueLeft = (Collection) object;
			Collection valueRight = (Collection) value.getValue();
			if (valueLeft.size() == 0 || valueRight.size() == 0)
				return false;
			return !Collections.disjoint(valueLeft, valueRight);
		}

		@Override
		public boolean evaluate(InternalWorkingMemory workingMemory, InternalReadAccessor extractor,
				InternalFactHandle factHandle, FieldValue value) {
			return evaluate(workingMemory, extractor, (Object) factHandle.getObject(), value);
		}

		@Override
		public boolean evaluate(InternalWorkingMemory workingMemory, InternalReadAccessor leftExtractor,
				InternalFactHandle left, InternalReadAccessor rightExtractor, InternalFactHandle right) {
			final Object value1 = leftExtractor.getValue(workingMemory, left.getObject());
			final Object value2 = rightExtractor.getValue(workingMemory, right.getObject());
			return !Collections.disjoint((Collection) value1, (Collection) value2);
		}

		@Override
		public boolean evaluateCachedLeft(InternalWorkingMemory workingMemory, VariableContextEntry context,
				InternalFactHandle right) {
			final Collection value = (Collection) context.extractor.getValue(workingMemory, right.getObject());
			return !Collections.disjoint(value, (Collection) ((ObjectVariableContextEntry) context).left);
		}

		@Override
		public boolean evaluateCachedRight(InternalWorkingMemory workingMemory, VariableContextEntry context,
				InternalFactHandle left) {
			final Collection value = (Collection) ((ObjectVariableContextEntry) context).right;
			return !Collections.disjoint(value,
					(Collection) context.declaration.getExtractor().getValue(workingMemory, left.getObject()));
		}
	}

	public static class NonIntersectEvaluator extends BaseEvaluator {
		public final static Evaluator INSTANCE = new NonIntersectEvaluator();

		public NonIntersectEvaluator() {
			super(ValueType.OBJECT_TYPE, NOT_INTERSECT_COMPARE);
		}

		public boolean evaluate(InternalWorkingMemory workingMemory, InternalReadAccessor extractor, Object object,
				FieldValue value) {
			final Object objectValue = extractor.getValue(workingMemory, object);
			return Collections.disjoint((Collection) objectValue, (Collection) value.getValue());
		}

		@Override
		public boolean evaluate(InternalWorkingMemory workingMemory, InternalReadAccessor extractor,
				InternalFactHandle factHandle, FieldValue value) {
			return evaluate(workingMemory, extractor, (Object) factHandle, value);
		}

		@Override
		public boolean evaluate(InternalWorkingMemory workingMemory, InternalReadAccessor leftExtractor,
				InternalFactHandle left, InternalReadAccessor rightExtractor, InternalFactHandle right) {
			final Object value1 = leftExtractor.getValue(workingMemory, left.getObject());
			final Object value2 = rightExtractor.getValue(workingMemory, right.getObject());
			return Collections.disjoint((Collection) value1, (Collection) value2);
		}

		@Override
		public boolean evaluateCachedLeft(InternalWorkingMemory workingMemory, VariableContextEntry context,
				InternalFactHandle right) {
			final Collection value = (Collection) context.extractor.getValue(workingMemory, right.getObject());
			return Collections.disjoint(value, (Collection) ((ObjectVariableContextEntry) context).left);
		}

		@Override
		public boolean evaluateCachedRight(InternalWorkingMemory workingMemory, VariableContextEntry context,
				InternalFactHandle left) {
			final Collection value = (Collection) ((ObjectVariableContextEntry) context).right;
			return Collections.disjoint(value,
					(Collection) context.declaration.getExtractor().getValue(workingMemory, left.getObject()));
		}
	}
}