package Data;

public class URL 
{
	public int id;
	public String name = null;
	public String path;
        public boolean protected_resources = false;
	public String userGroup = null;
	public URL(int id, String name, String path, boolean protected_resources, String userGroup)
	{
		this.id = id;
		this.name = name;
		this.path = path;
		this.protected_resources = protected_resources;
		this.userGroup = userGroup;
	}
	public URL(int id, String name, String path)
	{
		this.id = id;
		this.name = name;
		this.path = path;
	}
	public URL(String name, String path)
	{
		this.name = name;
		this.path = path;
	}
        public URL(int id, String path)
	{
		this.id = id;
		this.path = path;
	}
	@Override
	public String toString() 
        {
		return "URL_id = " + id + ", protected = " + protected_resources + ", user_group = " + userGroup + ", name = " + name + " -> " + path;
	}
	
}
