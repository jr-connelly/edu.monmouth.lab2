package edu.monmouth.lab2;

import edu.monmouth.employee.*;

public class EmployeeList {
	private EmployeeNode head;

	public EmployeeList() {
		head = null;
	}

	public void add(MuEmployee element) {
		// insert this MUEmployee object at the end of the list
		if (element == null) {
			return;
		}
		EmployeeNode newNode = new EmployeeNode(element);
		if (head == null) {
			head = newNode;
			return;
		}
		EmployeeNode last = getLastNode();
		last.setNext(newNode);
		newNode.setPrevious(last);
	}

	public boolean find(MuEmployee employee) {
	    // iterate thru list comparing each node's info to parameter
		EmployeeNode current = head;
		while (current != null) {
			if (current.getInfo().equals(employee)) {
				return true;

			}
			current = current.getNext();
		}
	   	return false;
	}

	public String printReverse() {
		// start at the last node and follow the previous links back to head
		StringBuilder result = new StringBuilder();
		EmployeeNode current = getLastNode();
		while (current != null) {
			result.append(current).append(" ");
			current = current.getPrevious();
		}
		return result.toString();
	}
	@Override
	public String toString() {
		// start at head and follow the next links to the end
		StringBuilder result = new StringBuilder();
		EmployeeNode current = head;
		while (current != null) {
			result.append(current).append("\n");
			current = current.getNext();
		}
		return result.toString();
	}

	private EmployeeNode getLastNode() {
		if (head == null) {
			return null;
		}
		EmployeeNode current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}
}
