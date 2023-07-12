package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EntryProcess {
	public void execute(Entry e,List<Entry> list) {
		Date today =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateTime =sdf.format(today);
		e.setDateTime(dateTime);
		list.add(0,e);
	}

}
