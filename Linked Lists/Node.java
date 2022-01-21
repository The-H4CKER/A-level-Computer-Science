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

	Node(int dataField) {
		this.dataField = dataField;
	}

	Node GetNxtNode() {
		return nxtNode;
	}

	Node GetPrvNode() {
		return prvNode;
	}

	int GetDataField() {
		return dataField;

	}

	void SetNxtNode(Node nxtNode) {
		this.nxtNode = nxtNode;
	}

	void SetPrvNode(Node prvNode) {
		this.prvNode = prvNode;
	}

	void SetDataField(int dataField) {
		this.dataField = dataField;
	}

	public String toString() {
		String txt = "\nData Field: \t" + dataField;
		if (prvNode != null)
			txt += "\n" + "Previous node:\t" + prvNode.dataField;
		if (nxtNode != null)
			txt += "\n" + "Previous node:\t" + nxtNode.dataField;
		return txt;
	}
}
