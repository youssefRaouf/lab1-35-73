package eg.edu.alexu.csd.filestructure.sort;
 
public class Node implements INode {
    private Comparable val;
    private int pos;
    private Node leftChild=null;
    private Node RightChild=null;
    private Node parent=null;
    Node(int pos,Node Parent)
    {
        if(pos<=0)
        {
            return ;
        }
        this.pos=pos;
        this.parent=Parent;
        if(pos!=1)
        {
            if(pos%2==0)
            {
                parent.leftChild=this;
            }
            else
                parent.RightChild=this;
        }
    }
 
    @Override
    public INode getLeftChild() {
        // TODO Auto-generated method stub
        if(!HasLeftChild())
            return null;
        return leftChild;
    }
    public boolean HasLeftChild()
    {
        if(leftChild==null)
        {
            return false;
        }
        return true;
    }
 
    public Node(Comparable val) {
        this.val = val;
    }
 
    @Override
    public INode getRightChild() {
        // TODO Auto-generated method stub
        if(!HasRightChild())
            return null;
        return RightChild;
    }
    public boolean HasRightChild()
    {
        if(RightChild==null)
            return false;
        return true;
    }
 
    @Override
    public INode getParent() {
        // TODO Auto-generated method stub
        if(!HasParent())
            return null;
        return parent;
    }
    public boolean HasParent()
    {
        if(parent==null)
            return false;
        return true;
    }
    @Override
    public Comparable getValue() {
        // TODO Auto-generated method stub
        return this.val;
    }
 
    @Override
    public void setValue(Comparable value) {
        // TODO Auto-generated method stub
        this.val=value;
 
    }
 
 
}