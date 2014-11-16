package db.structure.items.implementation;

import db.structure.items.Root;
import db.structure.items.SystemXML;

public class SystemXMLImpl implements SystemXML {
	private Root root;

	@Override
	public Root getRoot() {
		return root;
	}

	@Override
	public void setRoot(Root root) {
		this.root = root;
	}

}
