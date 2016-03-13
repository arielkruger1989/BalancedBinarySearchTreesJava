/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BalanceBinarySearchTree;

/**
 *
 * @author ariel
 */
public abstract class BalancedBinaryTree<T extends Comparable<?>> extends BinarySearchTree<T>{
    protected Integer rank = 0;

    public BalancedBinaryTree(T value) {
        super(value);
    }
    
    public void setRank(Integer r){
        rank = r;
    }
    
    public Integer getRank(){
        return rank;
    }
    
    public abstract boolean isBalanced();
    
    public abstract void updateRank();
    
    public Integer getLeftChildRank(){
        if(left != null) return ((BalancedBinaryTree)left).getRank();
        
        return 0;
    }
    
    public Integer getRightChildRank(){
        if(right != null) return ((BalancedBinaryTree)right).getRank();
        
        return 0;
    }
    
    public BalancedBinaryTree findUnbalancedNode(){
        updateRank();
        
        if(!isBalanced()) return this;
        else if(parent != null) return ((BalancedBinaryTree)parent).findUnbalancedNode();
        return null;
    }
    
    public abstract void rotate();
    
}
