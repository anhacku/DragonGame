package game;

public enum DragonSize {

	LARGE,
	MEDIUM,
	SMALL;
	
	public static DragonSize getSize(int nSize)
	{
		if (nSize == 0)
		{
			return DragonSize.LARGE;
		}
		else if (nSize == 1)
		{
			return DragonSize.MEDIUM;
		}
		
		return DragonSize.SMALL;
	}
	
}
