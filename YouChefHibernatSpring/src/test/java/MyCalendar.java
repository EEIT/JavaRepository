

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyCalendar {
	static final int MONTHS_A_YEAR = 12;
	static final int WEEKS_A_MONTH = 5;
	static final int DAYS_A_WEEK = 7;
	int year;
	int month;
	String[][][] myCalendar;
	static final String[] MONTH_TITLE = { "�@�� January", "�G�� February", "�T�� March", "�|�� April", "���� May", "���� June",
			"�C�� July", "�K�� August", "�E�� September", "�Q�� October", "�Q�@�� November", "�Q�G�� December" };

	public MyCalendar(int year) {
		this.year = year;
		myCalendar = new String[MONTHS_A_YEAR][WEEKS_A_MONTH][DAYS_A_WEEK];
		for (int i = 0; i < MONTHS_A_YEAR; i++) {
			for (int j = 0; j < WEEKS_A_MONTH; j++) {
				for (int k = 0; k < DAYS_A_WEEK; k++)
					myCalendar[i][j][k] = "";
			}
		}
		setDays(year);
		display(year);
	}

	public MyCalendar(int year, int month) {
		this.year = year;
		this.month = month;
		myCalendar = new String[1][WEEKS_A_MONTH][DAYS_A_WEEK];
		for (int j = 0; j < WEEKS_A_MONTH; j++) {
			for (int k = 0; k < DAYS_A_WEEK; k++)
				myCalendar[0][j][k] = "";
		}
		setDays(year, month);
		display(year, month);
	}

	public void setDays(int year) {
		GregorianCalendar gc;
		for (int i = 0; i < MONTHS_A_YEAR; i++) {
			gc = new GregorianCalendar(year, i, 1);
			int max = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
			int count = 0;
			A: for (int j = 0; j < WEEKS_A_MONTH; j++) {
				for (int k = 0; k < DAYS_A_WEEK; k++) {
					if (j == 0 && k < gc.get(Calendar.DAY_OF_WEEK) - 1)
						continue;
					else {
						count++;
						myCalendar[i][j][k] = (count < 10) ? "  " + Integer.toString(count)
								: " " + Integer.toString(count);
						if (count == max)
							break A;
					}
				}
				if (j == 4 && count < max) {
					for (int m = 0; m < 2; m++) {
						count++;
						myCalendar[i][j][m] += "/" + Integer.toString(count);
						if (count == max)
							break A;
					}
				}
			}
		}
	}

	public void setDays(int year, int month) {
		GregorianCalendar gc;
		gc = new GregorianCalendar(year, month, 1);
		int max = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
		int count = 0;
		A: for (int j = 0; j < WEEKS_A_MONTH; j++) {
			for (int k = 0; k < DAYS_A_WEEK; k++) {
				if (j == 0 && k < gc.get(Calendar.DAY_OF_WEEK) - 1)
					continue;
				else {
					count++;
					myCalendar[0][j][k] = (count < 10) ? "  " + Integer.toString(count) : " " + Integer.toString(count);
					if (count == max)
						break A;
				}
			}
			if (j == 4 && count < max) {
				for (int m = 0; m < 2; m++) {
					count++;
					myCalendar[0][j][m] += "/" + Integer.toString(count);
					if (count == max)
						break A;
				}
			}
		}
	}

	public void display(int year) {
		System.out.println("\t\t\t\t\t\t    " + year);
		for (int k = 0; k < MONTHS_A_YEAR; k += 2) {
			setTitle(k, 2);
			for (int i = 0; i < WEEKS_A_MONTH; i++) {
				StringBuilder sb = new StringBuilder(30);
				for (int j = 0; j < DAYS_A_WEEK; j++) {
					sb.append(myCalendar[k][i][j]).append("\t");
				}
				for (int j = 0; j < DAYS_A_WEEK; j++) {
					sb.append(myCalendar[k + 1][i][j]).append("\t");
				}
				System.out.println(sb);
			}
		}
	}

	public void display(int year, int month) {
		System.out.println("\t\t        " + year);
		setTitle(month - 1, 1);
		for (int i = 0; i < WEEKS_A_MONTH; i++) {
			StringBuilder sb = new StringBuilder(30);
			for (int j = 0; j < DAYS_A_WEEK; j++) {
				sb.append(myCalendar[0][i][j]).append("\t");
			}
			System.out.println(sb);
		}
	}

	private void setTitle(int k, int num) {
		StringBuilder sb = new StringBuilder(300);
		switch (num) {
		case 1:
			sb.append("=====================================================\n");
			sb.append("\t\t            ");
			sb.append(MONTH_TITLE[k]);
			sb.append("\n=====================================================\n");
			sb.append("�P����\t�P���@\t�P���G\t�P���T\t�P���|\t�P����\t�P����");
			break;
		case 2:
			sb.append("=====================================================\t"
					+ "=====================================================\n");
			sb.append(
					(k > 6) ? "\t\t            " + MONTH_TITLE[k] + "\t\t\t\t\t" + "            " + MONTH_TITLE[k + 1]
							: "\t\t            " + MONTH_TITLE[k] + "\t\t\t\t\t\t            " + MONTH_TITLE[k + 1]);
			sb.append("\n=====================================================\t"
					+ "=====================================================\n");
			sb.append("�P����\t�P���@\t�P���G\t�P���T\t�P���|\t�P����\t�P����\t�P����\t�P���@" + "\t�P���G\t�P���T\t�P���|\t�P����\t�P����");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		try {
			MyCalendar mc = (args.length == 2) ? new MyCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]))
					: new MyCalendar(Integer.parseInt(args[0]));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("�п�J���d�ߦ~���Τ���I�I");
		}
	}
}
