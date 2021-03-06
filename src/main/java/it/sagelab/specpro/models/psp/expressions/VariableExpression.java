package it.sagelab.specpro.models.psp.expressions;

/**
 * The Class VariableExpression.
 *
 * @author = Simone Vuotto
 * creation date  =  03/09/15.
 */
abstract public class VariableExpression extends Expression{
    
    /** The name. */
    protected String name;

    /**
     * Instantiates a new variable expression.
     *
     * @param name the name
     */
    public VariableExpression(String name){
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName(){ return name; }

    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return name;
    }
}
