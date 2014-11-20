package dao.entities;

import java.util.List;

import db.structure.items.implementation.Ferryman;

public interface FerrymanDao {
	public Ferryman getFerrymanById(Long id);
	public Ferryman createFerryman(Ferryman ferryman);
	public Ferryman updateFerryman(Ferryman ferryman);
	public void deleteFerryman(Ferryman ferryman);
	
	public List<Ferryman> findFerrymanByName(String name);
}
