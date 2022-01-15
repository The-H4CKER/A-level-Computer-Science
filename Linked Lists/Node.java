package lists;

public class Node {
	
	int dataField;
	Node prvNode;
	Node nxtNode;
	
	Node(int dataField, Node prvNode, Node nxtNode) {
		this.dataField = dataField;
		this.prvNode = prvNode;
		this.nxtNode = nxtNode;
	}
		
	int getDataField() {
		return this.dataField;
	}
	
	Node getPrvNode() {
		return this.prvNode;
	}
	
	Node getNxtNode() {
		return this.nxtNode;
	}
	
	void setDataField(int dataField) {
		this.dataField = dataField;
	}
	
	void setPrvNode(Node node) {
		this.prvNode = node;
	}
	
	void setNxtNode(Node node) {
		this.nxtNode = node;
	}
	
	
	public String toString() {
		String string = "Data Field: " + this.dataField + "\n";
		if (this.prvNode != null) {
			string += "Previous Node: " + this.prvNode.dataField + "\n";
		}
		if (this.nxtNode != null) {
			string += "Next Node: " + this.nxtNode.dataField + "\n";
		}
		return string;
	}
	
}
