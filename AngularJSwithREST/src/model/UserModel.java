package model;

import orm.User;

public class UserModel extends AbstractModel<User> {
	public UserModel() {
		super(User.class);
	}
}
