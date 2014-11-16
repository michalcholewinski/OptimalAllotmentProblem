package db.structure.items;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "SystemXML")
public interface SystemXML {
		public Root getRoot();
		public void setRoot(Root root);
		
}
