
public class Spice {

	/*String Spice = " Full Wave Rectifier\n"+
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
".end\n";*/

	
	String Spice = 	"Full Wave Rectifier\n"+

	"\n"+"*declaring model\n"+
	"\n"+
	".MODEL DIO D( IS=1.8E-10 RS=2 BV=50.0 IBV=1e-4+ CJO=1e-12 M=0.333 N=2.06 TT=4.32e-9 VJ=1e-6)\n"+
	"\n"+
	"*resister between nodes 1,2\n"+
	"Rs 1 2 0.0011\n"+
	"\n"+
	"*primary winding i.e. inductor\n"+
	"Lp 2 0 1mH\n"+
	"*secondary windings\n"+
	"Ls1 3 0 1mH\n"+
	"Ls2 0 4 1mH\n"+
	"\n"+
	"*declaring diodes\n"+
	"D1 3 5 DIO\n"+
	"D2 4 5 DIO\n"+
	"\n"+
	"R2 5 0 1K\n"+
	"\n"+
	"*declaring coupling coefficients between inductors\n"+
	"Kps  Lp  Ls1  1\n"+
	"Kps1  Lp  Ls2  1\n"+
	"Kss  Ls1  Ls2  1\n"+
	"\n"+
	"*declaring capacitor\n"+
	"C1 5 0 0u\n"+
	"\n"+
	"*declaring sinusoidal voltage\n"+
	"v1 1 0 sin(0 16V 50)\n"+
	"\n"+
	"*start the transient analysis\n"+
	".tran 0.001m 40m\n"+
	"\n"+
	"*control statement for simulation\n"+
	".control\n"+
	"*run the simulation\n"+
	"run\n"+
	"*plot the output curve between voltage on node 1 and 5\n"+
	"plot v(1) v(5)\n"+
	"*end of the control statement\n"+
	".endc\n"+
	"*end of the netlist\n"+
	".end";
	

}
