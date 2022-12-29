package gameModified;

public enum MDragonSize {

	LARGE,
	MEDIUM,
	SMALL;
	
	public static MDragonSize getSize(int nSize)
	{
		if (nSize == 0)
		{
			return MDragonSize.LARGE;
		}
		else if (nSize == 1)
		{
			return MDragonSize.MEDIUM;
		}
		
		return MDragonSize.SMALL;
	}
	
}
