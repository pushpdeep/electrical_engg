
public class Spice {

	String Spice = " Half Wave Rectifier\n"+
			""+
"\n"+
"*declaring the model\n"+
".MODEL DIO D( IS=1.8E-10 RS=2 BV=50.0 IBV=1e-4+ CJO=1e-12 M=0.333 N=2.06 TT=4.32e-9 VJ=1e-6)\n"+
"\n"+
"\n"+
"*declaring the diode using the model\n"+ 
"D1 1 2 DIO\n"+
"*declaring resister, try changing value of resister\n"+
"RL 3 0 1K\n"+
"*for adding capacitor, try changing value of capacitor\n"+
"C1 3 0 0u\n"+
"*declaring dc voltage source for measuring current\n"+
"V2 2 3 dc 0V\n"+
"\n"+
"*declaring sinusoidal voltage source\n"+
"v1 1 0 sin(0 16V 50)\n"+
"\n"+
"*start transient analysis\n"+
".tran 1ms 50ms\n"+
"\n"+
"*start of control statement\n"+
".control\n"+
"*run the simulation\n"
+"\n"+
"run\n"+
"*plotting input and output together\n"+
"plot v(3), v(1)"+"\n"+
"*plot the current through diode"+"\n"+
"*plot i(V2)"+"\n"+
"*end of control statement"+"\n"+
".endc"+"\n"+
"\n"+
"*end of netlist\n"+
".end\n";


}
