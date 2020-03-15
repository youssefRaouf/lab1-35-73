package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Heap implements IHeap {
	private Node Nodes[];
	private Node root;
	private int size;
	private int capacity;

	Heap(int capacity) {
		this.capacity = capacity;
		Nodes = new Node[capacity + 1];
		size = 0;
	}

	Heap() {
		this.capacity = 10000;
		Nodes = new Node[10001];
		size = 0;
	}

	@Override
	public INode getRoot() {
		// TODO Auto-generated method stub
		if(Nodes[1]==null||Nodes[1].getValue()==null) {
			return null;
		}
		return Nodes[1];
	}

	private void ensureExtraCapacity() {
		if (size == capacity) {
			Nodes = Arrays.copyOf(Nodes, capacity * 2);
			this.capacity = this.capacity * 2;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	private void swap(INode a, INode b) {
		INode temp = new Node(a.getValue());
		a.setValue(b.getValue());
		b.setValue(temp.getValue());
	}

	private void heapifyup(int i) {
		if (i == 1) {
			return;
		}
		INode Parent = Nodes[i].getParent();
		if (Nodes[i].getValue().compareTo(Parent.getValue()) == 1) {
			swap(Nodes[i], Parent);
			heapifyup(i / 2);
		}
	}

	@Override
	public void heapify(INode node) {
		// TODO Auto-generated method stub

		if (node == null || (node.getRightChild() == null && node.getLeftChild() == null)) {
			return;
		}
		if (node.getValue() == null)
			return;
		INode left = node.getLeftChild();
		INode right = node.getRightChild();

		if (node.getLeftChild() != null && node.getLeftChild().getValue() != null && node.getRightChild() != null
				&& node.getRightChild().getValue() != null) {
			if (node.getValue().compareTo(left.getValue()) == -1 || node.getValue().compareTo(right.getValue()) == -1) {
				if (left.getValue().compareTo(right.getValue()) == 1) {
					swap(left, node);
					heapify(left);
				} else {
					swap(right, node);
					heapify(right);
				}
			}
		} else {
			if (node.getLeftChild() != null && node.getLeftChild().getValue() != null) {
				if (node.getValue().compareTo(left.getValue()) == -1) {
					swap(left, node);
					heapify(left);
				}
			}
			else if(node.getRightChild() != null && node.getRightChild().getValue() != null) {
				if (node.getValue().compareTo(right.getValue()) == -1) {
					swap(left, node);
					heapify(left);
				}
			}
		}
	}

	@Override
	public Comparable extract() {
		if (size == 0) {
			return null;
		}
		// TODO Auto-generated method stub
		Comparable Max = getRoot().getValue();
		swap(Nodes[1], Nodes[size]);
		Nodes[size].setValue(null);
		size--;
		heapify(Nodes[1]);
		return Max;
	}

	@Override
	public void insert(Comparable element) {
		// TODO Auto-generated method stub
		if (element == null) {
			return;
		}
		size++;
		ensureExtraCapacity();
		Node New = new Node(size, Nodes[size / 2]);
		New.setValue(element);
		Nodes[size] = New;
		heapifyup(size);
	}

	@Override
	public void build(Collection unordered) {
		// TODO Auto-generated method stub
		if (unordered == null) {
			return;
		}

		this.capacity = unordered.size();
		this.Nodes = new Node[this.capacity + 1];
		this.size = 0;

		Iterator a = unordered.iterator();
		while (a.hasNext()) {
			Comparable t = (Comparable) a.next();
			insert(t);
		}

	}

}