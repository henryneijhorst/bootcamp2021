package sr.bludots.memory;

public interface StorageInterface {

	
	public void save(String name, String content);
	
	
	public String load(String name);
	
	public void delete(String name);
}
