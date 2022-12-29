package gameModified;

public class MRed extends MDragon {
	
	public String sName;
	
	public MRed(String sName, MDragonSize nSize)
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
	public void defend(MDragon obOther) {
		// TODO Auto-generated method stub
		
		float fAttack = obOther.getAttack();
		
		//Based on Color of Dragon
		if (obOther instanceof MGreen)
		{
			fAttack = (float) (fAttack * 0.2);
		}
		else if (obOther instanceof MWhite)
		{
			fAttack = (float) (fAttack * 0.5);
		}
		
		//Based on The Dragon Size
		if (obOther.nSize == MDragonSize.SMALL)
		{
			fAttack = (float) (fAttack * 0.7);
		}
		else if (obOther.nSize == MDragonSize.MEDIUM)
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
