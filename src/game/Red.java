package game;

public class Red extends Dragon {
	
	public String sName;
	
	public Red(String sName, DragonSize nSize)
	{
		super(nSize);
		this.sName = sName;
		
	}
	
	
	@Override
	public String toString()
	{
		return String.format("%s\n", this.sName) + super.toString();
	}


	@Override
	public void defend(Dragon obOther) {
		// TODO Auto-generated method stub
		
		float fAttack = obOther.getAttack();
		
		//Based on Color of Dragon
		if (obOther instanceof Green)
		{
			fAttack = (float) (fAttack * 1.2);
		}
		else if (obOther instanceof White)
		{
			fAttack = (float) (fAttack * 0.8);
		}
		
		//Based on The Dragon Size
		if (obOther.nSize == DragonSize.SMALL)
		{
			fAttack = (float) (fAttack * 0.7);
		}
		else if (obOther.nSize == DragonSize.MEDIUM)
		{
			fAttack = (float) (fAttack * 0.8);
		}
		
		//make sure that the defense is lower than the attack so it not return negative number
		if (fAttack - this.getDefense() >= 0)
		{
			this.setnHitPoints((int) (this.getnHitPoints() - (fAttack - this.getDefense())));
		}
		
		
	}
	
	
	

}
