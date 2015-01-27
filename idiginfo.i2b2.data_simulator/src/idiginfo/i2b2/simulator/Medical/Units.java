package idiginfo.i2b2.simulator.Medical;

import java.util.HashMap;
import java.util.Map;

public enum Units {
	u_Per_l(1,"u/l"),
	mosm_Per_kg(2,"mosm//kg"),
	pg_Per_ml(3,"pg/ml"),
	sec(4,"sec"),
	m_Per_ul(5,"m//ul"),
	pg_Per_rbc(6,"pg/rbc"),
	mm_Per_hr(7,"mm/hr"),
	mil_Per_cmm(8,"mil/cmm"),
	mm_Per_hg(9,"mm/hg"),
	mmhg(10,"mmhg"),
	_Per_hpf(11,"/hpf"),
	mm_Hg(12,"mm Hg"),
	beats_Per_minute(13,"beats/minute"),
	mg_Per_inh(14,"mg/inh"),
	iu(15,"iu"),
	meq_Per_l(16,"meq/l"),
	mg_Per_l(17,"mg/l"),
	uu_Per_ml(18,"uu/ml"),
	mg(19,"mg"),
	g_Per_dl(20,"g/dl"),
	mg_Per_ml(21,"mg/ml"),
	mcg_Per_dl(22,"mcg/dl"),
	_Per_lpf(23,"/lpf"),
	ug_Per_dl(24,"ug/dl"),
	th_Per_cumm(25,"th/cumm"),
	k3_Per_ul(26,"k3/ul"),
	inch(27,"inch"),
	mcg_Per_inh(28,"mcg/inh"),
	gm_Per_50ml(29,"gm/50ml"),
	mg_Per_dl(30,"mg/dl"),
	percent(31,"%"),
	units(32,"units"),
	units_Per_l(33,"units/l"),
	kg_Per_m2(34,"kg/m2"),
	ml(35,"ml"),
	gm_Per_dl(36,"gm/dl"),
	k_Per_ul(37,"k/ul"),
	breaths_Per_minute(38,"breaths/minute"),
	lb(39,"lb"),
	th_Per_mm3(40,"th/mm3"),
	fio2_Per_l(41,"fio2/l"),
	fl(42,"fl"),
	mins(43,"mins"),
	gm(44,"gm"),
	gm_Per_15ml(45,"gm/15ml"),
	At(46,"@"),
	mmol_Per_l(47,"mmol/l"),
	ng_Per_ml(48,"ng/ml"),
	th_Per_cmm(49,"th/cmm"),
	iu_Per_ml(50,"iu/ml"),
	F(51,"F"),
	mg_Per_5ml(52,"mg/5ml"),
	u_Per_ml(53,"u/ml"),
	DegC(54,"DEG_C");

	protected int Index;
	protected String Code;
	protected static Map<Integer, Units> IndexToCode;
	private Units(int index, String code)
	{
		Index = index;
		Code = code;
	}
	
	public static String getCode(int index)
	{
		if(IndexToCode==null){
			init();
		}
		return ((Units)IndexToCode.get(index)).Code();
	}
	
	private static void init()
	{
		IndexToCode = new HashMap<Integer, Units>();
		for(Units u: values())
		{
			IndexToCode.put(u.Index(), u);
		}
	}
	public String Code(){
		return Code;
	}
	public int  Index()
	{
		return Index;
	}
}
