package it.sagelab.specpro.models.psp.realtime;

import java.util.List;

import it.sagelab.specpro.models.psp.Requirement;
import it.sagelab.specpro.models.psp.Scope;
import it.sagelab.specpro.models.psp.Time;
import it.sagelab.specpro.fe.snl2fl.visitor.RealTimeRequirementVisitor;
import it.sagelab.specpro.models.psp.expressions.Expression;

/**
 * The Class RealTimeRequirement.
 *
 * @author Simone Vuotto
 */
public abstract class RealTimeRequirement extends Requirement {
    
    /** The time. */
    private final Time time;

    /**
     * Instantiates a new real time requirement.
     *
     * @param scope the scope
     * @param expressions the expressions
     * @param t the t
     */
    public RealTimeRequirement(Scope scope, List<Expression> expressions, Time t) {
        super(scope, expressions);
        this.time = t;
    }

    /**
     * Accept.
     *
     * @param visitor the visitor
     */
    public abstract void accept(RealTimeRequirementVisitor visitor);

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public Time getTime() {
		return time;
	}
    
    
}
