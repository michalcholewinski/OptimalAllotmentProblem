package facade.implementation.assembler;

import db.structure.items.implementation.User;
import facade.implementation.dts.UserDtsImpl;
import facade.interfaces.dts.UserDts;

public class UserAssembler {

	public User dtsToEntity(UserDts dts){
		User user = new User();
		user.setId(dts.getId());
		user.setLogin(dts.getLogin());
		user.setName(dts.getName());
		user.setPassword(dts.getPassword());
		user.setRole(dts.getRole());
		user.setSurname(dts.getSurname());
		return user;
	}
	
	public UserDts entityToDts(User entity){
		UserDts user = new UserDtsImpl();
		user.setId(entity.getId());
		user.setLogin(entity.getLogin());
		user.setName(entity.getName());
		user.setPassword(entity.getPassword());
		user.setRole(entity.getRole());
		user.setSurname(entity.getSurname());
		return user;
	}
}
