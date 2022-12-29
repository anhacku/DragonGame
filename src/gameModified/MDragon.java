package gameModified;


public abstract class MDragon implements Comparable<MDragon> {
	
	private int nAttackRank;
	private int nDefenseRank;
	private int nHitPoints;
	private int nInitiative;
	
	private int nHitPointsOri;
	
	private int nWin;



	public MDragonSize nSize;
	

	
	public MDragon(MDragonSize nSize)
	{
		
		this.nSize = nSize;
		
		this.nWin = 0;
		
		if (nSize == MDragonSize.SMALL)
		{
			this.nHitPointsOri = 82;
			this.nInitiative = 21;
			this.nAttackRank = 39;
			this.nDefenseRank = 10;
			
		}
		
		else if (nSize == MDragonSize.MEDIUM)
		{
			this.nHitPointsOri = 76;
			this.nInitiative = 23;
			this.nAttackRank = 50;
			this.nDefenseRank = 26;
		}
		
		else if (nSize == MDragonSize.LARGE)
		{
			this.nHitPointsOri = 90;
			this.nInitiative = 20;
			this.nAttackRank = 69;
			this.nDefenseRank = 32;
		}
	}
	
	public void addWinBattle()
	{
		this.nWin = this.nWin + 1;
	}
	
	
	public int getInitiative()
	{
		return this.nInitiative;
	}
	
	public int getNumAttackPerTurn()
	{
		if (this.nSize == MDragonSize.SMALL)
		{
			return 5;
		}
		else if (this.nSize == MDragonSize.MEDIUM)
		{
			return 9;
		}
		 
		return 2;
	}
	
	public boolean isDead()
	{
		return (this.nHitPoints <= 0);
		//true
	}
	
	public void ressurect()
	{
		this.nHitPoints = this.nHitPointsOri;
	}
	
	public int getAttack()
	{
		//rating???
		return this.nAttackRank;
	}

	public int getDefense()
	{
		return this.nDefenseRank;
	}
	
	
	@Override
	public String toString()
	{
		//TODO print all 6 private bla bla
		
		return String.format("Size: %s\tAttack Rank: %d\t\tDefense Rank: %d\tHP Origin: %d\tInitiative: %d\tWin %d battles\n", 
				this.getnSize(), this.getAttack(), this.getDefense(), this.getnHitPointsOri(), this.getInitiative(), this.getnWin());
	}
	
	
	public int getnHitPoints() {
		return nHitPoints;
	}


	public int getnHitPointsOri() {
		return nHitPointsOri;
	}

	public MDragonSize getnSize() {
		return nSize;
	}

	//Setter
	public void setnAttackRank(int nAttackRank) {
		this.nAttackRank = nAttackRank;
	}

	public void setnDefenseRank(int nDefenseRank) {
		this.nDefenseRank = nDefenseRank;
	}

	public void setnHitPoints(int nHitPoints) {
		this.nHitPoints = nHitPoints;
	}

	public void setnInitiative(int nInitiative) {
		this.nInitiative = nInitiative;
	}

	public void setnHitPointsOri(int nHitPointsOri) {
		this.nHitPointsOri = nHitPointsOri;
	}

	public void setnSize(MDragonSize nSize) {
		this.nSize = nSize;
	}
	
	public int getnWin()
	{
		return this.nWin;
	}

	
	public abstract void defend(MDragon obOther);
	
	
	@Override
	public int compareTo(MDragon o)
	{
		if (this.getnWin() > o.getnWin())
		{
			return -1;
		}
		else if (this.getnWin() < o.getnWin())
		{
			return 1;
		}
		
		return 0;
		
	}
	
	
}
