package snl2fl.ltl;

import java.util.HashMap;
import java.util.TreeMap;

import snl2fl.fl.elements.Atom;
import snl2fl.req.expressions.*;
import snl2fl.req.visitor.ExpressionVisitor;

/**
 * @author Simone Vuotto
 */
public class RangeMapVisitor implements ExpressionVisitor {

    HashMap<String, TreeMap<Float, Atom[]>> rangeMap = new HashMap<>();

    public HashMap<String, TreeMap<Float, Atom[]>> getRangeMap(){
        return rangeMap;
    }

    @Override
    public void visitBooleanExpression(BooleanExpression exp) {

    }

    @Override
    public void visitCompareExpression(CompareExpression exp) {
        if(exp.getLeftExp() instanceof FloatVariableExpression && exp.getRightExp() instanceof FloatVariableExpression)
            return; //Special case to be evaluated
        if(exp.getLeftExp() instanceof FloatVariableExpression)
            add((FloatVariableExpression) exp.getLeftExp(),  (NumberExpression) exp.getRightExp());
        else
            add((FloatVariableExpression) exp.getRightExp(), (NumberExpression) exp.getLeftExp());

    }

    @Override
    public void visitBooleanVariableExpression(BooleanVariableExpression exp) {

    }

    @Override
    public void visitNumberExpression(NumberExpression exp) {

    }

    @Override
    public void visitFloatVariableExpression(FloatVariableExpression exp) {

    }

    private void add(FloatVariableExpression var, NumberExpression exp) {

        TreeMap<Float, Atom[]> treeMap = rangeMap.get(var.getName());
        if(treeMap == null) {
            treeMap = new TreeMap<>();
            rangeMap.put(var.getName(), treeMap);
        }
        if(!treeMap.containsKey(exp.floatValue())) {
            Atom [] atoms = new Atom[2];
            atoms[0] = new Atom("_lower_"+var.getName()+treeMap.size());
            atoms[1] = new Atom("_equal_"+var.getName()+treeMap.size());
            treeMap.put(exp.floatValue(), atoms);
        }

    }

}