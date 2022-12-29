package game;

public class White extends Dragon {
	
	public String sName;
	
	public White(String sName, DragonSize nSize)
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
		float fAttack = this.getAttack();
		
		//Based on the Color of Dragon
		if (obOther instanceof Red)
		{
			fAttack = (float) (fAttack * 1.2);
		}
		else if (obOther instanceof Green)
		{
			fAttack = (float) (fAttack * 0.9);
		}
		else if (obOther instanceof Black)
		{
			fAttack = (float) (fAttack * 0.75);
		}
		
		//Based on Dragon Size
		if (this.nSize == DragonSize.SMALL)
		{
			fAttack = (float) (fAttack * 0.7);
		}
		else if (this.nSize == DragonSize.MEDIUM)
		{
			fAttack = (float) (fAttack * 0.8);
		}
		
		
		if (fAttack - this.getDefense() >= 0)
		{
			this.setnHitPoints((int) (this.getnHitPoints() - (fAttack - this.getDefense())));
		}
		
	}

}
