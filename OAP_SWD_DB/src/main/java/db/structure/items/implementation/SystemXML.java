package db.structure.items.implementation;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "SystemXML")
public class SystemXML {
	private Root root;

	public Root getRoot() {
		return root;
	}

	public void setRoot(Root root) {
		this.root = root;
	}

}
