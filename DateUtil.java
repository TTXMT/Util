import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	
	//����һ�굱��ÿ���·ֵ����һ�����ں�����
	private static final int[] dayArray = new int[] { 31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31 };
	//��ʼ�������ڸ�ʽ��ʵ��
	private static SimpleDateFormat sdf = new SimpleDateFormat();	
	
	/**
	 * ����ϵͳ��ǰ���뼶����ʱ��(����Calendar)
	 * @param 
	 * @return String  2019-01-15 11:25:33,097
	 */
	public static synchronized String getDateMilliFormatCalendar() {
		Calendar cal = Calendar.getInstance();
		return getDateMilliFormat(cal);
	}

	/**
	 * ����ϵͳ��ǰ���뼶����ʱ��(����Date)
	 * @param 
	 * @return String  2019-01-15 11:59:50,322
	 */
	public static synchronized String getDateMilliFormatDate() {
		return getDateMilliFormat(new Date());
	}
	
	/**
	 * ���뼶Calendar����תString
	 * @param calendar
	 * @return String yyyy-MM-dd HH:mm:ss,SSS
	 */
	public static synchronized String getDateMilliFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return getDateFormat(cal, pattern);
	}

	/**���뼶date����תString
	 * @param date
	 * @return String yyyy-MM-dd HH:mm:ss,SSS
	 */
	public static synchronized String getDateMilliFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return getDateFormat(date, pattern);
	}

	/**
	 * ���뼶String�����ַ���תCalendar
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarMilliFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * ���뼶String�����ַ���תDate
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateMilliFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		return parseDateFormat(strDate, pattern);
	}

	/**
	 * ����ϵͳ��ǰ�뼶����ʱ��(����Calendar)
	 * @param 
	 * @return String  2019-01-15 11:25:33
	 */
	public static synchronized String getDateSecondFormatCalendar() {
		Calendar cal = Calendar.getInstance();
		return getDateSecondFormat(cal);
	}

	/**
	 * ����ϵͳ��ǰ�뼶����ʱ��(����Date)
	 * @param 
	 * @return String  2019-01-15 11:59:50
	 */
	public static synchronized String getDateSecondFormatDate() {
		return getDateSecondFormat(new Date());
	}
	
	/**
	 * �뼶Calendar����תString
	 * @param calendar
	 * @return String yyyy-MM-dd HH:mm:ss
	 */
	public static synchronized String getDateSecondFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(cal, pattern);
	}

	/**
	 * �뼶Date����תString
	 * @param calendar
	 * @return String yyyy-MM-dd HH:mm:ss
	 */
	public static synchronized String getDateSecondFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return getDateFormat(date, pattern);
	}

	/**
	 * �뼶String����תCalendar
	 * @param calendar
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarSecondFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * �뼶String����תCalendar
	 * @param calendar
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateSecondFormat(String strDate) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return parseDateFormat(strDate, pattern);
	}
	
	/**
	 * ����ϵͳ��ǰ����(����Calendar)
	 * @param 
	 * @return String  2019-01-15
	 */
	public static synchronized String getDateDayFormatCalendar() {
		Calendar cal = Calendar.getInstance();
		return getDateDayFormat(cal);
	}

	/**
	 * ����ϵͳ��ǰ����(����Date)
	 * @param 
	 * @return String  2019-01-15
	 */
	public static synchronized String getDateDayFormatDate() {
		return getDateSecondFormat(new Date());
	}
	
	/**
	 * �ռ�CalendarתString
	 * @param cal
	 * @return String
	 */
	public static synchronized String getDateDayFormat(java.util.Calendar cal) {
		String pattern = "yyyy-MM-dd";
		return getDateFormat(cal, pattern);
	}

	/**
	 * �ռ�DateתString
	 * @param date
	 * @return String
	 */
	public static synchronized String getDateDayFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd";
		return getDateFormat(date, pattern);
	}

	/**
	 * �ռ�StringתCalendar
	 * @param strDate
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarDayFormat(String strDate) {
		String pattern = "yyyy-MM-dd";
		return parseCalendarFormat(strDate, pattern);
	}

	/**
	 * �ռ�StringתDate
	 * @param strDate
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateDayFormat(String strDate) {
		String pattern = "yyyy-MM-dd";
		return parseDateFormat(strDate, pattern);
	}
			
	/**
	 * @param Calendarʵ��
	 * @param pattern ���ڲ�����ʽ
	 * @return String
	 */
	public static synchronized String getDateFormat(java.util.Calendar cal,String pattern) {
		return getDateFormat(cal.getTime(), pattern);
	}
		
	/**
	 * @param date Dateʵ��
	 * @param pattern ���ڲ�����ʽ
	 * @return String
	 */
	public static synchronized String getDateFormat(java.util.Date date,String pattern) {
		synchronized (sdf) {
			String str = null;
			sdf.applyPattern(pattern);
			str = sdf.format(date);
			return str;
		}
	}

	/**
	 * @param strDate�����ַ���
	 * @param pattern���ڲ�����ʽ
	 * @return java.util.Calendar
	 */
	public static synchronized Calendar parseCalendarFormat(String strDate,String pattern) {
		synchronized (sdf) {
			Calendar cal = null;
			sdf.applyPattern(pattern);
			try {
				sdf.parse(strDate);
				cal = sdf.getCalendar();
			} catch (Exception e) {
			}
			return cal;
		}
	}

	/**
	 * @param strDate�����ַ���
	 * @param pattern���ڲ�����ʽ
	 * @return java.util.Date
	 */
	public static synchronized Date parseDateFormat(String strDate,String pattern) {
		synchronized (sdf) {
			Date date = null;
			sdf.applyPattern(pattern);
			try {
				date = sdf.parse(strDate);
			} catch (Exception e) {
			}
			return date;
		}
	}

	/**
	 * ���ݱ����·ݻ�ȡ���·����һ������ں�
	 * @param month �·�
	 * @return �ñ����·����һ������ں�
	 */
	public static synchronized int getLastDayOfMonth(int month) {
		if (month < 1 || month > 12) {
			return -1;
		}
		int retn = 0;
		if (month == 2) {
			if (isLeapYear()) {
				retn = 29;
			} else {
				retn = dayArray[month - 1];
			}
		} else {
			retn = dayArray[month - 1];
		}
		return retn;
	}

	/**
	 * ��������·ݻ�ȡ���·����һ������ں�
	 * @param year ���
	 * @param month �·�
	 * @return �����·����һ������ں�
	 */
	public static synchronized int getLastDayOfMonth(int year, int month) {
		if (month < 1 || month > 12) {
			return -1;
		}
		int retn = 0;
		if (month == 2) {
			if (isLeapYear(year)) {
				retn = 29;
			} else {
				retn = dayArray[month - 1];
			}
		} else {
			retn = dayArray[month - 1];
		}
		return retn;
	}

	/**
	 * �жϱ����Ƿ�������
	 * @return boolean
	 */
	public static synchronized boolean isLeapYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	/**
	 * �жϴ�������Ƿ�����
	 * @param year
	 * @return  boolean
	 */
	public static synchronized boolean isLeapYear(int year) {
		/**
		 * ��ϸ��ƣ� 1.��400���������꣬���� 2.���ܱ�4������������ 3.�ܱ�4����ͬʱ���ܱ�100������������
		 * 3.�ܱ�4����ͬʱ�ܱ�100������������
		 */
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * �ж�ָ�����ڵ�����Ƿ�������
	 * @param date  ָ�����ڡ�      
	 * @return �Ƿ�����
	 */
	public static synchronized boolean isLeapYear(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.��400���������꣬���� 2.���ܱ�4������������ 3.�ܱ�4����ͬʱ���ܱ�100������������
		 * 3.�ܱ�4����ͬʱ�ܱ�100������������
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		int year = gc.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	/**
	 * �ж�ָ�����ڵ�����Ƿ�������
	 * @param calendar  ָ�����ڡ�      
	 * @return �Ƿ�����
	 */
	public static synchronized boolean isLeapYear(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.��400���������꣬���� 2.���ܱ�4������������ 3.�ܱ�4����ͬʱ���ܱ�100������������
		 * 3.�ܱ�4����ͬʱ�ܱ�100������������
		 */
		int year = gc.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	/**
	 * �õ�ָ�����ڵ�ǰһ��������
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ�ǰһ��������
	 */
	public static synchronized java.util.Date getPreviousWeekDay(java.util.Date date) {		
		/**
		 * ��ϸ��ƣ� 1.���date�������գ����3�� 2.���date�������������2�� 3.�����1��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, -3);
			break;
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, -2);
			break;
		default:
			gc.add(Calendar.DATE, -1);
			break;
		}
		return gc.getTime();		
		
	}

	/**
	 * �õ�ָ�����ڵĺ�һ��������
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵĺ�һ��������
	 */
	public static synchronized java.util.Date getNextWeekDay(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.���date�������壬���3�� 2.���date�������������2�� 3.�����1��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 2);
			break;
		default:
			gc.add(Calendar.DATE, 1);
			break;
		}
		return gc.getTime();
	}		

	/**
	 * ȡ��ָ�����ڵ���һ���µ����һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ���µ����һ��
	 */
	public static synchronized java.util.Date getLastDayOfNextMonth(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.����getNextMonth���õ�ǰʱ�� 2.��1Ϊ����������getLastDayOfMonth
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextMonth(gc.getTime()));
		gc.setTime(DateUtil.getLastDayOfMonth(gc.getTime()));
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ���һ�����ڵ����һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ�����ڵ����һ��
	 */
	public static synchronized java.util.Date getLastDayOfNextWeek(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.����getNextWeek���õ�ǰʱ�� 2.��1Ϊ����������getLastDayOfWeek
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextWeek(gc.getTime()));
		gc.setTime(DateUtil.getLastDayOfWeek(gc.getTime()));
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ���һ���µĵ�һ��
	 * 
	 * @param Date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ���µĵ�һ��
	 */
	public static synchronized java.util.Date getFirstDayOfNextMonth(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.����getNextMonth���õ�ǰʱ�� 2.��1Ϊ����������getFirstDayOfMonth
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextMonth(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfMonth(gc.getTime()));
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ���һ���µĵ�һ��
	 * 
	 * @param Calendar
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ���µĵ�һ��
	 */
	public static synchronized java.util.Calendar getFirstDayOfNextMonth(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.����getNextMonth���õ�ǰʱ�� 2.��1Ϊ����������getFirstDayOfMonth
		 */
		gc.setTime(DateUtil.getNextMonth(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfMonth(gc.getTime()));
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ���һ�����ڵĵ�һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ�����ڵĵ�һ��
	 */
	public static synchronized java.util.Date getFirstDayOfNextWeek(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.����getNextWeek���õ�ǰʱ�� 2.��1Ϊ����������getFirstDayOfWeek
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(DateUtil.getNextWeek(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfWeek(gc.getTime()));
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ���һ�����ڵĵ�һ��
	 * 
	 * @param Calendar
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ�����ڵĵ�һ��
	 */
	public static synchronized java.util.Calendar getFirstDayOfNextWeek(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.����getNextWeek���õ�ǰʱ�� 2.��1Ϊ����������getFirstDayOfWeek
		 */
		gc.setTime(DateUtil.getNextWeek(gc.getTime()));
		gc.setTime(DateUtil.getFirstDayOfWeek(gc.getTime()));
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ���һ����
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ����
	 */
	public static synchronized java.util.Date getNextMonth(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڵ��·ݼ�1
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.MONTH, 1);
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ���һ����
	 * 
	 * @param Calendar
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ����
	 */
	public static synchronized java.util.Calendar getNextMonth(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڵ��·ݼ�1
		 */
		gc.add(Calendar.MONTH, 1);
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ���һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ��
	 */
	public static synchronized java.util.Date getNextDay(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڼ�1��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.DATE, 1);
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ���һ��
	 * 
	 * @param Calendar
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ��
	 */
	public static synchronized java.util.Calendar getNextDay(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڼ�1��
		 */
		gc.add(Calendar.DATE, 1);
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ���һ������
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ������
	 */
	public static synchronized java.util.Date getNextWeek(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڼ�7��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.DATE, 7);
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ���һ������
	 * 
	 * @param Calendar
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ���һ������
	 */
	public static synchronized java.util.Calendar getNextWeek(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.ָ�����ڼ�7��
		 */
		gc.add(Calendar.DATE, 7);
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ��������ڵ����һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ��������ڵ����һ��
	 */
	public static synchronized java.util.Date getLastDayOfWeek(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.���date�������գ����6�� 2.���date������һ�����5�� 3.���date�����ڶ������4��
		 * 4.���date�������������3�� 5.���date�������ģ����2�� 6.���date�������壬���1��
		 * 7.���date�������������0��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 6);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, 5);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, 4);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, 2);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 1);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 0);
			break;
		}
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ��������ڵ����һ��
	 * 
	 * @param Calendar
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ��������ڵ����һ��
	 */
	public static synchronized java.util.Calendar getLastDayOfWeek(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.���date�������գ����6�� 2.���date������һ�����5�� 3.���date�����ڶ������4��
		 * 4.���date�������������3�� 5.���date�������ģ����2�� 6.���date�������壬���1��
		 * 7.���date�������������0��
		 */
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 6);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, 5);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, 4);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, 3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, 2);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, 1);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, 0);
			break;
		}
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ��������ڵĵ�һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ��������ڵĵ�һ��
	 */
	public static synchronized java.util.Date getFirstDayOfWeek(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.���date�������գ����0�� 2.���date������һ�����1�� 3.���date�����ڶ������2��
		 * 4.���date�������������3�� 5.���date�������ģ����4�� 6.���date�������壬���5��
		 * 7.���date�������������6��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 0);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, -1);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, -2);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, -3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, -4);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, -5);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, -6);
			break;
		}
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ��������ڵĵ�һ��
	 * 
	 * @param Calendar
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ��������ڵĵ�һ��
	 */
	public static synchronized java.util.Calendar getFirstDayOfWeek(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.���date�������գ����0�� 2.���date������һ�����1�� 3.���date�����ڶ������2��
		 * 4.���date�������������3�� 5.���date�������ģ����4�� 6.���date�������壬���5��
		 * 7.���date�������������6��
		 */
		switch (gc.get(Calendar.DAY_OF_WEEK)) {
		case (Calendar.SUNDAY):
			gc.add(Calendar.DATE, 0);
			break;
		case (Calendar.MONDAY):
			gc.add(Calendar.DATE, -1);
			break;
		case (Calendar.TUESDAY):
			gc.add(Calendar.DATE, -2);
			break;
		case (Calendar.WEDNESDAY):
			gc.add(Calendar.DATE, -3);
			break;
		case (Calendar.THURSDAY):
			gc.add(Calendar.DATE, -4);
			break;
		case (Calendar.FRIDAY):
			gc.add(Calendar.DATE, -5);
			break;
		case (Calendar.SATURDAY):
			gc.add(Calendar.DATE, -6);
			break;
		}
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ������·ݵ����һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ������·ݵ����һ��
	 */
	public static synchronized java.util.Date getLastDayOfMonth(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.���date��1�£���Ϊ31�� 2.���date��2�£���Ϊ28�� 3.���date��3�£���Ϊ31��
		 * 4.���date��4�£���Ϊ30�� 5.���date��5�£���Ϊ31�� 6.���date��6�£���Ϊ30��
		 * 7.���date��7�£���Ϊ31�� 8.���date��8�£���Ϊ31�� 9.���date��9�£���Ϊ30��
		 * 10.���date��10�£���Ϊ31�� 11.���date��11�£���Ϊ30�� 12.���date��12�£���Ϊ31��
		 * 1.���date�������2�£���Ϊ29��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(Calendar.MONTH)) {
		case 0:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 1:
			gc.set(Calendar.DAY_OF_MONTH, 28);
			break;
		case 2:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 3:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 4:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 5:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 6:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 7:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 8:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 9:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 10:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 11:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		}
		// �������
		if ((gc.get(Calendar.MONTH) == Calendar.FEBRUARY)
				&& (isLeapYear(gc.get(Calendar.YEAR)))) {
			gc.set(Calendar.DAY_OF_MONTH, 29);
		}
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ������·ݵ����һ��
	 * 
	 * @param Calendar
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ������·ݵ����һ��
	 */
	public static synchronized java.util.Calendar getLastDayOfMonth(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.���date��1�£���Ϊ31�� 2.���date��2�£���Ϊ28�� 3.���date��3�£���Ϊ31��
		 * 4.���date��4�£���Ϊ30�� 5.���date��5�£���Ϊ31�� 6.���date��6�£���Ϊ30��
		 * 7.���date��7�£���Ϊ31�� 8.���date��8�£���Ϊ31�� 9.���date��9�£���Ϊ30��
		 * 10.���date��10�£���Ϊ31�� 11.���date��11�£���Ϊ30�� 12.���date��12�£���Ϊ31��
		 * 1.���date�������2�£���Ϊ29��
		 */
		switch (gc.get(Calendar.MONTH)) {
		case 0:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 1:
			gc.set(Calendar.DAY_OF_MONTH, 28);
			break;
		case 2:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 3:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 4:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 5:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 6:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 7:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 8:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 9:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 10:
			gc.set(Calendar.DAY_OF_MONTH, 30);
			break;
		case 11:
			gc.set(Calendar.DAY_OF_MONTH, 31);
			break;
		}
		// �������
		if ((gc.get(Calendar.MONTH) == Calendar.FEBRUARY)
				&& (isLeapYear(gc.get(Calendar.YEAR)))) {
			gc.set(Calendar.DAY_OF_MONTH, 29);
		}
		return gc;
	}

	/**
	 * ȡ��ָ�����ڵ������·ݵĵ�һ��
	 * 
	 * @param date
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ������·ݵĵ�һ��
	 */
	public static synchronized java.util.Date getFirstDayOfMonth(java.util.Date date) {
		/**
		 * ��ϸ��ƣ� 1.����Ϊ1��
		 */
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return gc.getTime();
	}

	/**
	 * ȡ��ָ�����ڵ������·ݵĵ�һ��
	 * 
	 * @param Calendar
	 *            ָ�����ڡ�
	 * @return ָ�����ڵ������·ݵĵ�һ��
	 */
	public static synchronized java.util.Calendar getFirstDayOfMonth(java.util.Calendar gc) {
		/**
		 * ��ϸ��ƣ� 1.����Ϊ1��
		 */
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return gc;
	}

	/**
	 * �����ڶ���ת����Ϊָ��ORA���ڡ�ʱ���ʽ���ַ�����ʽ��������ڶ���Ϊ�գ����� һ�����ַ������󣬶�����һ���ն���
	 * 
	 * @param theDate
	 *            ��Ҫת��Ϊ�ַ��������ڶ���
	 * @param hasTime
	 *            ������ص��ַ�����ʱ����Ϊtrue
	 * @return ת���Ľ��
	 */
	public static synchronized String toOraString(Date theDate, boolean hasTime) {
		/**
		 * ��ϸ��ƣ� 1.�����ʱ�䣬�����ø�ʽΪgetOraDateTimeFormat()�ķ���ֵ
		 * 2.�������ø�ʽΪgetOraDateFormat()�ķ���ֵ 3.����toString(Date theDate, DateFormat
		 * theDateFormat)
		 */
		DateFormat theFormat;
		if (hasTime) {
			theFormat = getOraDateTimeFormat();
		} else {
			theFormat = getOraDateFormat();
		}
		return toString(theDate, theFormat);
	}

	/**
	 * �����ڶ���ת����Ϊָ�����ڡ�ʱ���ʽ���ַ�����ʽ��������ڶ���Ϊ�գ����� һ�����ַ������󣬶�����һ���ն���
	 * 
	 * @param theDate
	 *            ��Ҫת��Ϊ�ַ��������ڶ���
	 * @param hasTime
	 *            ������ص��ַ�����ʱ����Ϊtrue
	 * @return ת���Ľ��
	 */
	public static synchronized String toString(Date theDate, boolean hasTime) {
		/**
		 * ��ϸ��ƣ� 1.�����ʱ�䣬�����ø�ʽΪgetDateTimeFormat�ķ���ֵ 2.�������ø�ʽΪgetDateFormat�ķ���ֵ
		 * 3.����toString(Date theDate, DateFormat theDateFormat)
		 */
		DateFormat theFormat;
		if (hasTime) {
			theFormat = getDateTimeFormat();
		} else {
			theFormat = getDateFormat();
		}
		return toString(theDate, theFormat);
	}

	/**
	 * ��׼���ڸ�ʽ
	 */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	/**
	 * ��׼ʱ���ʽ
	 */
	private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	/**
	 * ORA��׼���ڸ�ʽ
	 */
	private static final SimpleDateFormat ORA_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	/**
	 * ORA��׼ʱ���ʽ
	 */
	private static final SimpleDateFormat ORA_DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");

	/**
	 * ����һ����׼���ڸ�ʽ�Ŀ�¡
	 * 
	 * @return ��׼���ڸ�ʽ�Ŀ�¡
	 */
	public static synchronized DateFormat getDateFormat() {
		/**
		 * ��ϸ��ƣ� 1.����DATE_FORMAT
		 */
		SimpleDateFormat theDateFormat = (SimpleDateFormat) DATE_FORMAT.clone();
		theDateFormat.setLenient(false);
		return theDateFormat;
	}

	/**
	 * ����һ����׼ʱ���ʽ�Ŀ�¡
	 * 
	 * @return ��׼ʱ���ʽ�Ŀ�¡
	 */
	public static synchronized DateFormat getDateTimeFormat() {
		/**
		 * ��ϸ��ƣ� 1.����DATE_TIME_FORMAT
		 */
		SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) DATE_TIME_FORMAT.clone();
		theDateTimeFormat.setLenient(false);
		return theDateTimeFormat;
	}

	/**
	 * ����һ����׼ORA���ڸ�ʽ�Ŀ�¡
	 * 
	 * @return ��׼ORA���ڸ�ʽ�Ŀ�¡
	 */
	public static synchronized DateFormat getOraDateFormat() {
		/**
		 * ��ϸ��ƣ� 1.����ORA_DATE_FORMAT
		 */
		SimpleDateFormat theDateFormat = (SimpleDateFormat) ORA_DATE_FORMAT.clone();
		theDateFormat.setLenient(false);
		return theDateFormat;
	}

	/**
	 * ����һ����׼ORAʱ���ʽ�Ŀ�¡
	 * 
	 * @return ��׼ORAʱ���ʽ�Ŀ�¡
	 */
	public static synchronized DateFormat getOraDateTimeFormat() {
		/**
		 * ��ϸ��ƣ� 1.����ORA_DATE_TIME_FORMAT
		 */
		SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) ORA_DATE_TIME_FORMAT.clone();
		theDateTimeFormat.setLenient(false);
		return theDateTimeFormat;
	}

	/**
	 * ��һ�����ڶ���ת����Ϊָ�����ڡ�ʱ���ʽ���ַ����� ������ڶ���Ϊ�գ�����һ�����ַ�����������һ���ն���
	 * 
	 * @param theDate
	 *            Ҫת�������ڶ���
	 * @param theDateFormat
	 *            ���ص������ַ����ĸ�ʽ
	 * @return ת�����
	 */
	public static synchronized String toString(Date theDate,DateFormat theDateFormat) {
		/**
		 * ��ϸ��ƣ� 1.theDateΪ�գ��򷵻�"" 2.����ʹ��theDateFormat��ʽ��
		 */
		if (theDate == null)
			return "";
		return theDateFormat.format(theDate);
	}

	

	/**
	 * ����һ�����ڣ���2019-01-08   ���ظ��������ڵ����ڵ�һ�� ���ں����ڶ�Ӧ��ϵ��MAP
	 * @param date
	 * @return {2019-01-07=����һ, 2019-01-08=���ڶ�, 2019-01-09=������, 2019-01-10=������, 2019-01-11=������, 2019-01-12=������, 2019-01-13=������}
	 */
	public static TreeMap getWeekMap(String date) {
		TreeMap map = new TreeMap();
		Calendar c = DateUtil.parseCalendarDayFormat(date);
		c = DateUtil.getFirstDayOfWeek(c);
		c = DateUtil.getNextDay(c);
		for (int i = 2; i < 9; i++) {
			if (i == 8)
				i = i - 7;
			map.put(DateUtil.getDateDayFormat(c), DateUtil.getWeekChina(i));
			c = DateUtil.getNextDay(c);
			if (i == 1)
				i = i + 9;
		}
		return map;
	}
	

	public static synchronized String getWeekChina(int i) {
		String re = "����һ";
		switch (i) {
		case 1:
			re = "������";
			break;
		case 2:
			re = "����һ";
			break;
		case 3:
			re = "���ڶ�";
			break;
		case 4:
			re = "������";
			break;
		case 5:
			re = "������";
			break;
		case 6:
			re = "������";
			break;
		case 7:
			re = "������";
			break;
		}
		return re;
	}
	
	/**
	 * ����һ�����ڣ���2019-01-08   ���ظ��������ڵ��·ݵ�������һ��MAP������ʱ��κ����Ķ�Ӧ��ϵMAP��
	 * @param date
	 * @return {2018-12-30��2019-01-05=��һ��, 2019-01-06��2019-01-12=�ڶ���, 2019-01-13��2019-01-19=������, 2019-01-20��2019-01-26=������}
	 */
	public static TreeMap getMonthMap(String date) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		Calendar c = DateUtil.parseCalendarDayFormat(date);
		c = DateUtil.getFirstDayOfMonth(c);
		c = DateUtil.getFirstDayOfWeek(c);
		for (int i = 0; i < 4; i++) {
			StringBuffer value = new StringBuffer(DateUtil.getDateDayFormat(c));
			value.append("��");
			c = DateUtil.getLastDayOfWeek(c);
			value.append(DateUtil.getDateDayFormat(c));
			map.put(String.valueOf(value), getWeekNumberChina(i));
			c = DateUtil.getFirstDayOfNextWeek(c);
		}
		return map;
	}

	
	public static synchronized String getWeekNumberChina(int i) {
		String num = "";
		switch (i) {
		case 0:
			num = "��һ��";
			break;
		case 1:
			num = "�ڶ���";
			break;
		case 2:
			num = "������";
			break;
		case 3:
			num = "������";
			break;
		}
		return num;
	}
	
	/**
	 * Java Calender����ָ�����ڼӼ���
	 * @param specifiedDay
	 * @param d
	 *            day
	 * @return yyyy-MM-dd
	 */
	public static String getSpecifiedDayAfter(String specified, int d) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(specified);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + d);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayAfter;
	}

	/**
	 * �Ƚ�����ʱ��Ĵ�С
	 * @param DATE1
	 * @param DATE2
	 * @return 1:d1>d2, 2:d1<d2, 3:d1=d2
	 */
	public static int compareDate(String DATE1, String DATE2) {
		int a = 0;
		try {
			Date dt1 = new SimpleDateFormat("yyyy-MM-dd").parse(DATE1);
			Date dt2 = new SimpleDateFormat("yyyy-MM-dd").parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {				
				a = 1;
			} else if (dt1.getTime() < dt2.getTime()) {				
				a = 2;
			} else {		
				a = 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return a;
	}
	
	
}