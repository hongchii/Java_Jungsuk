package StudyProgram;

public interface StudyInfo {
	
	public void joinStudy(StudyVO[] std);
	public void inputStudy(StudyVO[] std);
	public void updateStudy(StudyVO[] std);
	public void processStudy();
	public void outputDeposit(StudyVO[] std);
	public void outputStudy();
	
}
