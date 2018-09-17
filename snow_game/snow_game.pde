Ball[] balls = new Ball[16];
Text te;
int score;
int n = 8;
int dia = 70;

int count=200;
float[] x=new float[count];
float[] y=new float[count];
float[] r=new float[count];
float[] s=new float[count];


color[] colors = { 
color(252, 36, 36, 178), //RED 
color(248, 114, 23, 178), //ORANGE
color(255, 255, 0, 178), //YELLOW
color(76, 196, 23, 178), //GREEN
color(56, 172, 236, 178), //BLUE
color(255, 193, 230, 178), //PINK
color(127, 56, 235, 178), // PURPLE
color(128, 178), //GREY
};
int index;
String[] headlines = {
"ORANGE", 
"GREY", 
"PINK", 
"YELLOW", 
"GREEN", 
"RED", 
"BLUE", 
"PURPLE", 
};
int index1=int(random(0,8));
boolean Gameover=false;

void setup() {
size(800,650);
smooth();
for(int i=0;i<count;i++){
x[i]=random(0,width);
y[i]=random(0,height);
r[i]=random(3,7);
s[i]=random(1,2);
}
noStroke();
startGame();
textSize(60);
textAlign(CENTER, BOTTOM);
}


void draw() {
background(0);

for(int i=0;i<count;i++){
if(y[i]>height){
y[i]=-5;
}
if(dist(mouseX,mouseY,x[i],y[i])<20){
y[i]=-5;
x[i]=random(0,width);
}
y[i]+=s[i];
ellipse(x[i],y[i],r[i],r[i]);
}

te.display();
for(int t=0;t<16;t++){
balls[t].display();
}
}


void mousePressed(){
if(Gameover==true){
loop();
startGame();
Gameover=false;
}
for(int t=0; t<balls.length; t++){
if(balls[t].over==true){
if(balls[t].colour!=te.h){
background(72);
gameOver();
Gameover=true;
noLoop();
}}}}


void mouseReleased(){
te=new Text(headlines[int(random(0,8))],colors[int(random(0,8))]);
}

void gameOver() {
fill(180);
textAlign(CENTER);
textSize(48);
text("GAME OVER", width/2, height/2);
textSize(25);
textAlign(CENTER);
text("Click to try again", width/2, height/2+height/4);
}


void startGame(){
background(175);
for (int t=0; t<balls.length; t++) {
balls[t] = new Ball(random(20, width-20), random(20, height/2-100), dia, 10.0,headlines[int(random(0,8))]);//size, speed
}
te=new Text(headlines[int(random(0,8))],colors[int(random(0,8))]); 
}
class Ball {
float x, y;
float D;
float dy;
boolean over=false;
boolean press=false;
String colour;
Ball(float x_, float y_, float D_, float dy_,String c) {
x = x_;
y = y_;
D = D_;
dy = dy_;
colour=c;
}
void display() {
if(dist(mouseX,mouseY,x,y)<=D/2){//判断鼠标是否在圆上
over=true;
}else{
over=false;
}

if((over==true)&&mousePressed){
press=true;
}

if((press==true)&&(y<height-D/2)){
y+=dy;
}
switch(colour){
case "ORANGE":fill(248, 114, 23, 178);break;
case "GREY":fill(128, 178);break;
case "PINK":fill(255, 193, 230, 178);break;
case "YELLOW":fill(255, 255, 0, 178);break;
case "GREEN":fill(76, 196, 23, 178);break;
case "RED":fill(252, 36, 36, 178);break;
case "BLUE":fill(56, 172, 236, 178);break;
case "PURPLE":fill(127, 56, 235, 178);break;
default:fill(0);break;
}
noStroke();
ellipse(x, y, D, D);
}
}


class Text{//start Game
String h;
color c;
Text(String th,color tc){
h=th;
c=tc;
textSize(60);
textAlign(CENTER);
}
void display(){
fill(c);
text(h, width/2, height/2);
}
}