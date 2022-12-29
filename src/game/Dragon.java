package game;


public abstract class Dragon implements Comparable<Dragon> {
	
	private int nAttackRank;
	private int nDefenseRank;
	private int nHitPoints;
	private int nInitiative;
	
	private int nHitPointsOri;
	
	private int nWin;



	public DragonSize nSize;
	

	
	public Dragon(DragonSize nSize)
	{
		
		this.nSize = nSize;
		
		this.nWin = 0;
		
		if (nSize == DragonSize.SMALL)
		{
			this.nHitPointsOri = (int) (Math.random() * (70 - 51 + 1) + 51);
			this.nInitiative = (int) (Math.random() * (60 - 40 + 1) + 40);
			this.nAttackRank = (int) (Math.random() * (50 - 36 + 1) + 36);
			this.nDefenseRank = (int) (Math.random() * (19 - 10 + 1) + 10);
			
		}
		
		else if (nSize == DragonSize.MEDIUM)
		{
			this.nHitPointsOri = (int) (Math.random() * (85 - 71 + 1) + 71);
			this.nInitiative = (int) (Math.random() * (40 - 20 + 1) + 20);
			this.nAttackRank = (int) (Math.random() * (60 - 51 + 1) + 51);
			this.nDefenseRank = (int) (Math.random() * (29 - 20 + 1) + 20);
		}
		
		else if (nSize == DragonSize.LARGE)
		{
			this.nHitPointsOri = (int) (Math.random() * (100 - 86 + 1) + 86);
			this.nInitiative = (int) (Math.random() * (10 - 0 + 1) + 0);
			this.nAttackRank = (int) (Math.random() * (70 - 61 + 1) + 61);
			this.nDefenseRank = (int) (Math.random() * (35 - 29 + 1) + 29);
		}
	}
	
	public void addWinBattle()
	{
		this.nWin = this.nWin + 1;
		//TODO why Win + 1?
	}
	
	
	public int getInitiative()
	{
		return this.nInitiative;
	}
	
	public int getNumAttackPerTurn()
	{
		if (this.nSize == DragonSize.SMALL)
		{
			return 3;
		}
		else if (this.nSize == DragonSize.MEDIUM)
		{
			return 2;
		}
		 
		return 1;
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

	public DragonSize getnSize() {
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

	public void setnSize(DragonSize nSize) {
		this.nSize = nSize;
	}
	
	public int getnWin()
	{
		return this.nWin;
	}

	
	public abstract void defend(Dragon obOther);
	
	
	@Override
	public int compareTo(Dragon o)
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

//⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⣤⣤⣤⣤⣤⣤⣤⣀⣀⠄⠄⠄⠄⠄⠄⠄⠄
//⠄⠄⠄⠄⠄⠄⢠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀⠄⠄⠄⠄
//⠄⠄⠄⠄⠄⣰⣿⣿⡟⠻⣿⠟⠻⣿⣿⠛⢻⣿⡿⠻⣿⣿⣿⣦⡀⠄⠄
//⠄⠄⠄⠄⣰⣿⡿⠋⠤⢤⡉⢰⡀⡈⢁⠄⠄⣙⡁⢀⡘⢿⢿⣿⣿⡄⠄
//⠄⠄⠄⢠⣿⣿⠁⠄⠄⠄⢳⡀⢉⡀⣼⠄⠄⢨⠞⠉⠄⣀⡀⢿⣿⣿⠄
//⠄⠄⣠⣼⣿⠇⠄⢀⡴⣒⢲⣷⠲⠇⠻⢧⣴⣿⢺⡙⣦⡌⠁⠄⣿⣿⣇
//⠄⡞⠁⠄⡼⠄⠄⢹⡧⣉⠊⡟⠂⠄⠄⠄⠈⡇⣏⡷⣸⠁⠄⠄⢹⣿⢡
//⠄⡇⠄⡀⠃⠄⠄⠄⠃⠩⠘⠂⢖⣛⠙⡦⠐⠛⠬⠕⠛⠃⠄⠄⠘⠃⢾
//⠄⠳⣴⠃⠈⠚⠄⢠⠄⠄⠄⠄⠄⣹⣉⣀⣀⠄⠄⠄⡀⢢⣠⠄⠄⠄⡀
//⠄⠄⡟⠄⠄⠄⠄⠘⢦⡤⠤⠖⠋⠉⠄⠄⠉⠉⠙⠲⡌⠃⠁⠄⠄⠄⣿
//⠄⠄⡇⠄⠄⠄⢆⡄⢸⣇⣠⠖⠚⠩⠟⠉⠉⠙⠓⢢⡇⠄⠄⠄⠄⠄⣿
//⠄⠄⡇⠄⠄⠄⠈⠄⠄⠙⢤⣤⠤⠖⠒⡒⠒⠒⠚⠁⠄⠐⡄⡀⠄⢀⡇
//⠄⠄⢹⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠉⠁⠄⠄⠄⠄⠄⠄⠉⠠⢆⡞⠄
//⠄⠄⠄⠱⣄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣠⠴⠋⠄⠄
//⠄⠄⠄⠄⠈⠓⠒⠒⠒⠒⠒⠒⠛⠉⠉⠉⠉⠉⠉⠉⠉⠉⠄⠄⠄⠄














