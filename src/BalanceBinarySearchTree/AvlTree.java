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
public class AvlTree<T extends Comparable<?>> extends BalancedBinaryTree<T>{

    public AvlTree(T value) {
        super(value);
    }
    
    public boolean isBalanced(){
        int leftHeight = (left != null ? ((AvlTree)left).rank : -1);
        int rightHeight = (right != null ? ((AvlTree)right).rank : -1);
        
        return Math.abs(leftHeight-rightHeight) <= 1;
        
    }
    
    /**
     *
     * @param value
     * @return
     */
    @Override
    public AvlTree insertNode(T value){
        this.insertNode(new AvlTree(value));
        return (AvlTree)this.getRoot();
    }
    
    public AvlTree deleteNode(T value){
        return this.deleteNode(new AvlTree(value));
         
    }
    
    @Override
    public AvlTree deleteNode(BinaryTree node){
        if(node.value.compareTo(this.value) == 0){
            if(this.parent != null){
                if(this.parent.left.value.compareTo(node.value) == 0)
                    this.parent.left = null;
                else
                    this.parent.right = null;
                
                AvlTree unbalanced = ((AvlTree)((AvlTree)this.parent).findUnbalancedNode());
                
                if(unbalanced != null){
                    unbalanced.rotate();
                }
                
            }
        }
        
        if(node.value.compareTo(this.value) < 0){
            if(this.left != null){
                this.left.deleteNode(node);
            }
        }else{
            if(this.right != null)
                this.right.deleteNode(node);
        }
        
        return (AvlTree)this.parent.getRoot();
    }
    
    
    @Override
    public void updateRank() {
        if(left == null && right == null) {
            rank = 0;
        }else{    
            rank = 1 + Math.max(left != null ? ((AvlTree)left).rank : 0, right != null ? ((AvlTree)right).rank : 0);
        }
    }
    
    public void setLeftChild(BinaryTree subtree, boolean rebalance){
        if(rebalance) setLeftChild(subtree);
        else{
            left = subtree;
            if(subtree != null) subtree.parent = this;
        }
    }
    
    public void setRightChild(BinaryTree subtree, boolean rebalance){
        if(rebalance) setRightChild(subtree);
        else{
            right = subtree;
            if(subtree != null) subtree.parent = this;
        }
    }
    
    @Override
    public void setLeftChild(BinaryTree subtree){
        left = subtree;
        subtree.parent = this;
        
        AvlTree Z = (AvlTree)findUnbalancedNode();
        
        if(Z != null) Z.rotate();
    }
    

    @Override
    public void setRightChild(BinaryTree subtree){
        right = subtree;
        subtree.parent = this;
        
        AvlTree Z = (AvlTree)findUnbalancedNode();
        if(Z != null) Z.rotate();

    }
    
    
    public boolean removeNode(T value){
        
        
        return false;
    }
    
    public AvlTree getChildWithHighestRank(){
        int leftHeight = (left != null ? ((AvlTree)left).rank : -1);
        int rightHeight = (right != null ? ((AvlTree)right).rank : -1);
        
        if(leftHeight > rightHeight){
            return (AvlTree) left;
        }
        
        return (AvlTree) right;
        //return ((leftHeight > rightHeight) ? node.left : node.right);
    }

    @Override
    public void rotate() {
        AvlTree Z = this;
        
        AvlTree Y = ((AvlTree)Z).getChildWithHighestRank();
        AvlTree X = ((AvlTree)Y).getChildWithHighestRank();
        
        //case 1
        if(Z.right == Y && Y.right == X){
            Y.setParent(Z.parent, Z);
            ((AvlTree)Z).setRightChild(Y.left, false);
            Y.setLeftChild(Z, false);
            Y.setRightChild(X, false);
            ((AvlTree)Z).updateRank();
            X.updateRank();
            Y.updateRank();
        }else if(Z.left == Y && Y.left == X){
            Y.setParent(Z.parent, Z);
            ((AvlTree)Z).setLeftChild(Y.right, false);
            Y.setRightChild(Z, false);
            Y.setLeftChild(X, false);
            ((AvlTree)Z).updateRank();
            X.updateRank();
            Y.updateRank();
        }else if(Z.left == Y && Y.right == X){
            Y.setRightChild(X.left, false);
            X.setLeftChild(Y, false);
            ((AvlTree)Z).setLeftChild((BinaryTree)X, false);
            Z.rotate();
        }else if(Z.right == Y && Y.left == X){
            ((AvlTree)Z).setRightChild(X,false);
            Y.setLeftChild(X.right, false);
            X.setRightChild(Y, false);
            Z.rotate();
        }
    }
    
    
    
    public static void main(String[] args){        
        
        AvlTree root = new AvlTree<Integer>(new Integer(44));
        root = root.insertNode(17);
        root = root.insertNode(32);
        root = root.insertNode(62);
        root = root.insertNode(50);
        root = root.insertNode(48);
        root = root.insertNode(54);
        root = root.insertNode(78);
        root = root.insertNode(88);
        
        
        root = root.deleteNode(17);
        
        
        root.print();
    }
}
