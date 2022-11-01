package key.domain;

public class User {
	private Long id;
	private String name;
	private String password;
	private Integer permId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPermId() {
		return permId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", permId=" + permId +
				'}';
	}

	public User() {
	}

	public User(Long id, String name, String password, Integer permId) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.permId = permId;
	}


	public User(String name, String password, Integer permId) {
		this.name = name;
		this.password = password;
		this.permId = permId;
	}
}
