class time_info {
  public time_info() {
  }
  
  public String get() {
    String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    return mydate;
  }
}
