package gameModified;

public class MWhite extends MDragon {
	
	public String sName;
	
	public MWhite(String sName, MDragonSize nSize)
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
		float fAttack = this.getAttack();
		
		//Based on the Color of Dragon
		if (obOther instanceof MRed)
		{
			fAttack = (float) (fAttack * 1.1);
		}
		else if (obOther instanceof MGreen)
		{
			fAttack = (float) (fAttack * 0.3);
		}
		else if (obOther instanceof MBlack)
		{
			fAttack = (float) (fAttack * 0.65);
		}
		
		//Based on Dragon Size
		if (this.nSize == MDragonSize.SMALL)
		{
			fAttack = (float) (fAttack * 0.7);
		}
		else if (this.nSize == MDragonSize.MEDIUM)
		{
			fAttack = (float) (fAttack * 0.8);
		}
		
		
		if (fAttack - this.getDefense() >= 0)
		{
			this.setnHitPoints((int) (this.getnHitPoints() - (fAttack - this.getDefense())));
		}
		
	}

}
