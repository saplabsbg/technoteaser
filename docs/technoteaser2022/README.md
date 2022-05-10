# SAP Техноблъсканица 2022

{::nomarkdown}
<div style="display:none"><img src="https://winwithsap.hana.ondemand.com/services/web/TechQuiz/user/images/sharePicture.jpg"></div>
<link rel="stylesheet" href="../styles/technoteaser.css">
<link rel="stylesheet" href="../styles/footer.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/latest.js?config=TeX-MML-AM_CHTML' async></script>

<input type="checkbox" id=week1Toggle>
<label for=week1Toggle class="week">
<h2 id=week1>Седмица №1 <span></span></h2>
</label>	
<div>
	<h3 id="week1,question1">Кой лъже?</h3>
	<p> 
Асен твърди, че Борис винаги лъже.<br>
Борис твърди, че Виктор винаги лъже.<br>
Виктор твърди, че Асен и Борис винаги лъжат.<br>
Кои хора лъжат? Приемаме, че всеки един измежду тримата или винаги лъже, или винаги казва истината.
<ul class="answersWithCheckbox">
	<li>Асен лъже</li>
	<li>Борис лъже</li>
	<li>Виктор лъже</li>
</ul>
	</p>
	<div>
		<input type="checkbox" id=solution11><label class="explanationbutton" for=solution11><span>Обяснение</span></label>
		<div class="explanation">
<ul><li>
Ако допуснем, че Асен казва истината, то Борис би следвало винаги да лъже, т.е. от твърдението на Борис ще следва, че Виктор винаги казва истината. Но Виктор твърди, че Асен винаги лъже (заедно с Борис), което влиза в противоречие с нашето допускане.
</li><li>
Ако Асен лъже, то Борис би следвало да казва истината, а от неговото твърдение ще следва, че Виктор лъже. Твърдението на Виктор ще е лъжа, ако или Асен, или Борис казват истината. Тъй като в този случай Борис наистина казва истината, то получаваме логически валидна конфигурация.
</li></ul>
Тъй като други валидни конфигурации няма, то <b>Асен и Виктор лъжат</b>, а Борис казва истината.
<hr>

В съждителната логика и булевата алгебра твърдението на Виктор е пример за <a href="https://bg.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BD%D1%8E%D0%BD%D0%BA%D1%86%D0%B8%D1%8F" target=_blank>конюнкция</a> на двете твърдения "Асен лъже" и "Борис лъже".<br>
От <a href="https://bg.wikipedia.org/wiki/%D0%97%D0%B0%D0%BA%D0%BE%D0%BD%D0%B8_%D0%BD%D0%B0_%D0%94%D0%B5_%D0%9C%D0%BE%D1%80%D0%B3%D0%B0%D0%BD" target=_blank>закона (или правилата) на Де Морган</a> oтрицанието на <a href="https://bg.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BD%D1%8E%D0%BD%D0%BA%D1%86%D0%B8%D1%8F" target=_blank>конюнкцията</a> е <a href="https://bg.wikipedia.org/wiki/%D0%94%D0%B8%D0%B7%D1%8E%D0%BD%D0%BA%D1%86%D0%B8%D1%8F" target=_blank>дизюнкция</a> на отрицанията. За твърдението на Виктор "Асен и Борис винаги лъжат" това означава, че то няма да бъде изпълнено (т.е. ще е лъжа), когато или "Асен не лъже", или "Борис не лъже".
		</div> 
	</div>
	<h3 id="week1,question2">Лодка във ваната</h3>
	<p>
Когато малкият Жорко построил своята лодка-макет, той искал веднага да я изпробва. Затова той напълнил ваната с вода и поставил лодката в нея. Макетът бил толкова сполучлив, че успявал да се задържи над водата дори когато Жорко поставил в него оловна тежест от 2 кг. Какво ще стане с нивото на водата във ваната, ако в този момент Жорко вземе тежестта от лодката и я пусне да падне на дъното (и ваната издържи на удара)?		
	</p>
	<div>
		<input type="checkbox" id=solution12><label class="explanationbutton" for=solution12><span>Обяснение</span></label>
		<div class="explanation">
Не е нужно да познаваме <a href="https://bg.wikipedia.org/wiki/%D0%97%D0%B0%D0%BA%D0%BE%D0%BD_%D0%BD%D0%B0_%D0%90%D1%80%D1%85%D0%B8%D0%BC%D0%B5%D0%B4" target=_blank>Закона на Архимед</a>, за да можем да преценим, че когато в лодката има тежест, то лодката потъва повече във водата, т.е. измества повече вода. От друга страна, когато вземем тази тежест, лодката плава по-плитко, измествайки по-малко вода. В граничния случай, когато във ваната въобще няма лодка (и изместена вода), нивото на водата ще бъде най-ниското възможно. Следователно нивото на водата във ваната ще се понижи, когато вземем тежестта от лодката.<br>
Какво става, когато пуснем тежестта във водата?<br>
Тя пада на дъното, тъй като оловото е много по-плътно от водата, измествайки толкова вода, колкото е обемът на самата тежест. И тук не е трудно да преценим, че този обем е много по-малък от обема на изместената от лодката вода, за да може тя да носи тежестта, откъдето получаваме и крайният отговор, че когато вземем тежестта от лодката и я пуснем на дъното, <b>нивото на водата във ваната ще се понижи</b>.
		</div> 
	</div>
	<h3 id="week1,question3">Специални числа</h3>
	<p>
Колко са естествените числа със сума на цифрите, както и произведение на цифрите, равни на 2022?<br>
Пример: Числото 25111 има сума на цифрите, както и произведение на цифрите, равни на 10.
<ul class="answersWithRadio">
	<li>Няма такива числа.</li>
	<li>Повече от \( 2^{3}\), но по-малко от \( 2^{5}\).</li>
	<li>Повече от \( 2^{5}\), но все пак краен брой.</li>
	<li>Има безкрайно много такива числа.</li>
</ul>
	</p>
	<div>
		<input type="checkbox" id=solution13><label class="explanationbutton" for=solution13><span>Обяснение</span></label>
		<div class="explanation">
Ако разложим числото \(2022\) на прости множители, ще видим, че \(2022 = 2*3*337\). Веднага можем да забележим, че цифрите \(2\) и \(3\) могат да бъдат удовлетворени, но няма как да съпоставим цифра за числото \(337\). От това следва, че условието произведението на цифрите да бъде равно на \(2022\) не може да бъде изпълнено, т.е. <b>такива числа няма</b>.
		</div> 
	</div>
</div>
<!-- end of week 1-->

<input type="checkbox" id=week2Toggle>
<label for=week2Toggle class="week">
<h2 id=week2>Седмица №2 <span></span></h2>
</label>
<div>
	<h3 id="week2,question1">Съкровище в парка</h3>
	<p>В парк има 29 алеи. По средата на една от алеите е заровено съкровище. Оказало се, че ако човек стигне от А до Б по нечетен брой алеи, без да минава по една и съща алея два пъти, той със сигурност ще пропусне алеята със съкровището. Ако пък стигне от А до Б по четен брой алеи, без да минава по една и съща алея два пъти, то една от изминатите алеи ще бъде алеята със съкровището.<br>Коя е алеята със съкровището?<br><img src="https://winwithsap.hana.ondemand.com/services/js/TechQuiz/DocumentService/GetDocument.js?id=bZeKi0gYSq4bdc7DneeJmO5EGTvTOrGnffRpmIldmj0"></p>
	<div>
		<input type="checkbox" id=solution21><label class="explanationbutton" for=solution21><span>Обяснение</span></label>
		<div class="explanation">
Търсим два пътя от А до Б, които се различават възможно най-малко, но единият има четен брой алеи, а другият — нечетен. Като се разделят и после пак се съберат, двата пътя ще заградят многоъгълник с нечетен брой алеи по контура. Такъв е например триъгълникът, ограден от алеите № 9, № 11 и № 12.<br>
Пътят 3-5-11-12-16-20-21 води от А до Б и има нечетен брой алеи, следователно съкровището не се намира по никоя от тях.<br>
Пътят 3-5-9-16-20-21 води от А до Б и има четен брой алеи, следователно минава през съкровището. <br>
За пет от тези алеи знаем, че не съдържат съкровището. Ето защо то се намира по средата на единствената останала алея от втория път — <b>алея № 9</b>.
<hr>
© Задача на Добромир Кралчев
		</div>
	</div>
	<h3 id="week2,question2">Влакът</h3>
	<p>Пътнически влак има общо 8 вагона. Във всеки 3 съседни вагона се возят общо 123 пътници. Ако всички пътници са общо 300, колко пътници се возят във вагон №3?<br>Aко точният им брой не може да бъде определен със сигурност, отговорете с английската буква u (от undefined).</p>
	<div>
		<input type="checkbox" id=solution22><label class="explanationbutton" for=solution22><span>Обяснение</span></label>
		<div class="explanation">
Нека означим пътниците във вагон номер \(i\) с \(v_i\). <br> Знаем, че \( v_1 + v_2 + \cdots + v_7 + v_8 = 300\) <br>
Тъй като  \( v_1 + v_2 + v_3 = v_4 + v_5 + v_6 = 123 \), получаваме   \(123 + 123 + v_7 + v_8 = 300 \implies v_7 + v_8 = 54\), a oт факта, че  \(v_6+v_7+v_8=123\) получаваме \( v_6 + 54=123 \implies v_6=69\). Oт тук по чисто симетрични съображения можем да заключим, че и \(v_3=69\), най-малкото защото индексирането на вагоните може да бъде направено и в обратен ред, като това не може да доведе до различно решение. Ако все пак искаме да изведем \(v_3\) директно, можем да съобразим, че \(v_3+v_4+v_5 = v_4+v_5 +v_6  \implies  v_3=v_6=69 \).<br>
Преди да заключим, че във вагон №3 се возят 69 пътници, трябва и да покажем, че съществува възможна подредба на пътниците в останалите вагони.
От \( v_7 + v_8 = 54 \) можем за удобство да приемем, че \(v_7=v_8=27\), като една възможна подредба на пътниците във влака ще бъде (27,27,69,27,27,69,27,27). С това можем да сме сигурни, че във вагон №3 се возят точно <b>69</b> пътници.
		</div>
	</div>
	<h3 id="week2,question3">Точни квадрати</h3> 
	<p>Колко са стоцифрените естествени числа, които са точни квадрати и чийто десетичен запис се състои само от цифрите  3,  5,  7  и  8 ?<br><small>Естественото число \(n\) е точен квадрат, ако \(\sqrt{n}\) е също естествено число.</small></p>
	<div>
		<input type="checkbox" id=solution23><label class="explanationbutton" for=solution23><span>Обяснение</span></label>
		<div class="explanation">
Ясно е, че задачата не може да се реши с груба сила (<a href="https://en.wikipedia.org/wiki/Brute-force_search" target=_blank>Brute-force</a>) - стоцифрените числа са твърде много. Както обикновено, колкото по-трудна изглежда една задача, толкова по-лесно се решава. Нужна е само малко досетливост. Всеки точен квадрат завършва на някоя от цифрите  0,  1,  4,  5,  6  и  9.   От тях само цифрата 5 може да бъде използвана. А ако един точен квадрат завършва на  5, то той завършва на 25:<br>

\( (10x + 5)^2 = 100x^2 + 100x + 25 = 100(x^2 + x) + 25 \) <br>

В последния израз първото събираемо завършва на две нули, затова целият сбор завършва на 25. Обаче цифрата 2 не е разрешена. Следователно не съществува точен квадрат, чийто десетичен запис се състои само от цифрите  3,  5,  7  и  8,  независимо по колко пъти е използвана всяка от тях.<br>
<b>Отговор: 0</b>
<hr>
© Задача на Добромир Кралчев
		</div>
	</div>
</div>

<!-- end of week 2-->
<input type="checkbox" id=week3Toggle>
<label for=week3Toggle class="week">
<h2 id=week3>Седмица №3 <span></span></h2>
</label>	
<div>
	<h3 id="week3,question1">Стая за всеки</h3>
	<p>Ася, Биби, Вили и Диди искали да се настанят в хотел. В хотела имало 10 свободни единични съседни стаи, като 1-вата и 10-тата стая били в началото и в края на коридора, т.е. те били съседни съответно само на 2-ра и 9-та стая. Момичетата имали следните изисквания:
<ul>
	<li>Ася и Биби били първи приятелки и те искали да са в съседни стаи.</li>
	<li>Вили и Диди също искали да са в съседни стаи.</li>
	<li>Ася и Вили били в конфликт и те не искали да са в съседни стаи.</li>
</ul>
По колко начина могат да се настанят момичетата?</p>
	<div>
		<input type="checkbox" id=solution31><label class="explanationbutton" for=solution31><span>Обяснение</span></label>
		<div class="explanation">
<h4 id="week3,solution31,ProgramSolution">Решението на програмиста:</h4>
Тъй като наличните стаи са само 10, то пълното генериране и преброяване на възможните конфигурации за настанявания изглежда разумно решение.
За да бъде алгоритъмът ефективен, обаче, трябва да генерираме всяка една възможна конфигурация за настаняване само веднъж. Причината за това е, че всички възможни пермутации на 10 елемента са \( 10! = 3628800 \), докато всички възможни пермутации на 10 елемента, от които един с повторение (в случая това са 6-те свободни стаи), са  \(  \dfrac{10!}{6!} = 5040 \).<br>
Имаме 5 вида стаи:
<pre><code>enum Room { ASIA, BIBI, VILI, DIDI, EMPTY}
Room getNeighbor(Room p) {
  switch (p) {
   case ASIA: return Room.BIBI;
   case BIBI: return Room.ASIA;
   case VILI: return Room.DIDI;
   case DIDI: return Room.VILI;
   default: return null;
  }
 }
 Room getUnwantedNeighbor(Room p) {
  switch (p) {
   case ASIA: return Room.VILI;
   case VILI: return Room.ASIA;
   default: return null;
  }
}
</code></pre>
Наличността на всяка от стаите можем да пазим в подходяща структура от данни:
<pre><code>Map<Room, Integer> rooms = new HashMap<>();
  rooms.put(Room.ASIA, 1);
  rooms.put(Room.BIBI, 1);
  rooms.put(Room.VILI, 1);
  rooms.put(Room.DIDI, 1);
  rooms.put(Room.EMPTY, 6);</code></pre>

<pre><code>int findPossibleConfigurations (Map<Room, Integer> availableRooms, Room unwantedNeighbor) {
  
    if (availableRooms.size() == 0) {
      //Recursion base case
      return 1;
    }
    
    int currentResult = 0;
    Room[] rooms = availableRooms.keySet().toArray(new Room[availableRooms.size()]);
    
    for (Room currentRoomType : rooms) {
      
      if (!currentRoomType.equals(unwantedNeighbor)) {
        int availableRoomsOfCurrentType = availableRooms.get(currentRoomType);
        if (availableRoomsOfCurrentType == 1) {
          availableRooms.remove(currentRoomType);
        } else {
          availableRooms.put(currentRoomType, availableRoomsOfCurrentType - 1);
        }
        //add also the neighbor in the next room
        Room requiredNeighbor = getNeighbor(currentRoomType);
        if (requiredNeighbor != null) {
          availableRooms.remove(requiredNeighbor);
        }
        
        currentResult += findPossibleConfigurations (availableRooms, getUnwantedNeighbor(currentRoomType));
        
        //revert changes
        if (requiredNeighbor != null) {
          availableRooms.put(requiredNeighbor, 1);
        }
        availableRooms.put(currentRoomType, availableRoomsOfCurrentType);
      }
    }
    
    return currentResult;
  }</code></pre>
<pre><code>System.out.println(findPossibleConfigurations(rooms, null));</code></pre>
<div style="background: #000;border: 1px solid #ccc; color: white; display: block;padding: 5px;width: 100%;font-size: 90%; ">210</div><br>

<a href="https://github.com/saplabsbg/technoteaser/blob/master/src/saptechnoteaser2022/week3/RoomDistribution.java" target=_blank>Примерен Java код</a><br><br>

<h4 id="week3,solution31,MathSolution">Решението на математика:</h4>
Нека първо разгледаме по-лесния случай, при който в коридора има точно 4 свободни стаи.<br>
Възможните разпределения по стаи са (АБ)(ВД),(АБ)(ДВ),(БА)(ДВ),(ВД)(АБ),(ВД)(БА),(ДВ)(БА) или общо 6.   
В допълнение имаме и 2 неприемливи комбинации - (БА)(ВД) и (ДВ)(АБ), при които Ася и Вили стоят в съседни стаи.<br>
Какви възможности имаме за добавяне на празни стаи между двойките?
За всички 6 възможни комбинации можем да добавяме празни стаи на 3 места - преди първата двойка съседни стаи, между двете двойки съседни стаи и след втората двойка съседни стаи: <nobr>_ <sub>1</sub>, (съседни стаи), _ <sub>2</sub>, (съседни стаи), _ <sub>3</sub>.</nobr><br>
По колко начина можем да разпределим останалите 6 свободни стаи измежду тези 3 възможни места?<br>
Както вече знаем от задачата за <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2021/#week4,question1" target=_blank>Голямото разпределяне</a> от миналата година, можем да разпределим стаите, ако ги подредим в редица и добавим 2 еднакви разделителя, т.е. <nobr>&#9898;&#9898;<b><big>||</big></b>&#9898;&#9898;&#9898;&#9898;</nobr> ще отговаря на разпределението 2 стаи на позиция _ <sub>1</sub>, 0 стаи на позиция _ <sub>2</sub> и 4 стаи на позиция _ <sub>3</sub>. Всички възможности за разпределение получаваме като <a href="https://bg.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%B1%D0%B8%D0%BD%D0%B0%D1%86%D0%B8%D1%8F_(%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0)" target=_blank>комбинация</a> (без повторение) на 2 елемента от клас 8, или:<br>
<div style="align:left; width: 1px; overflow: visible;">$$ C^2_{8} = {8 \choose 2} = \dfrac{8!}{2!(8-2)!} = \dfrac{8*7}{2} = 4*7 = 28 $$</div>
Тъй като имаме 6 възможни разпределения по двойки, към които можем да добавим свободните стаи, получаваме \( 28*6 = 168 \) възможности.<br>
Не трябва да забравяме и 2-те неприемливи разпределения, тъй като те биха станали приемливи, ако между Ася и Вили има поне една свободна стая. Така към тези 2 случая трябва да видим по колко начина можем да разпределим 5 свободни стаи (без тази, която поставяме между Ася и Вили). Аналогично на предходния случай, това е комбинация на 2 елемента от клас 7, или 
<div style="align:left; width: 1px; overflow: visible;">$$ C^2_{7} = {7 \choose 2} = \dfrac{7!}{2!(7-2)!} = \dfrac{7*6}{2} = 7*3 = 21 $$</div>
Така за двете първоначално неприемливи конфигурации получаваме \(2*21=42\) приемливи такива, а всички възможни начини за настаняване са \(168+42=210\).<br>
<b>Отговор: 210</b>
		</div>
	</div>
	<h3 id="week3,question2">Голямата пица</h3>
	<p>Огромна пица била разделена между 100 човека по следното правило:
<ul>
	<li>Първият човек взел парче, което било 1% от пицата.</li>
	<li>Вторият човек взел парче, което било 2% от тази част от пицата, която останала след първия човек.</li>
	<li style="list-style-type: none;">...</li>
	<li>n-тия по ред човек взел n % от текущо наличната пица.</li>
	<li style="list-style-type: none;">...</li>
	<li>Последният (100-тен по ред) човек взел 100%, т.е. цялата останала пица.</li>
</ul>
Кой по ред човек е взел най-голямото парче?</p>
	<div>
		<input type="checkbox" id=solution32><label class="explanationbutton" for=solution32><span>Обяснение</span></label>
		<div class="explanation">
<h4 id="week3,solution32,ProgramSolution">Решението на програмиста:</h4>
Лесно можем да изчислим по колко точно пица е получил всеки. За да не работим с твърде малки числа, можем да приемем (без това да е задължително), че пицата има 100 парчета. По този начин и крайният резултат за това кой колко (дробно число) парчета пица получава ще бъде всъщност количеството в проценти от цялата пица.
<pre><code>static final int NUMBER_OF_PEOPLE = 100;</code></pre>
<pre><code>double pizzaAmmount = 100;
  double maxPizzaAmmountTaken = 0;
  int maxPizzaAmmountTakenBy = 0;
  
  for (int i = 1; i <= NUMBER_OF_PEOPLE; i++) {
    double pizzaAmmountForCurrentPerson = pizzaAmmount*i/100;
    if (pizzaAmmountForCurrentPerson > maxPizzaAmmountTaken) {
    maxPizzaAmmountTaken = pizzaAmmountForCurrentPerson;
    maxPizzaAmmountTakenBy = i;
    }
    pizzaAmmount -= pizzaAmmountForCurrentPerson;
  }
  System.out.println("The maximum pizza amount goes to person " + maxPizzaAmmountTakenBy + 
     " taking " + maxPizzaAmmountTaken + " out of " + NUMBER_OF_PEOPLE + " pieces");</code></pre>
<div style="background: #000;border: 1px solid #ccc; color: white; display: block;padding: 5px;width: 100%;font-size: 90%;">The maximum pizza amount goes to person 10 taking 6.2815650955529465 out of 100 pieces</div>
<br>
<a href="https://github.com/saplabsbg/technoteaser/blob/master/src/saptechnoteaser2022/week3/TheBigPizza.java" target=_blank>Примерен Java код</a><br><br>

<h4 id="week3,solution32,MathSolution">Решението на математика:</h4>
<ul>
	<li>Първият човек е взел точно \(1\%\) от пицата, като след него останали \(\dfrac{99}{100}\) части от първоначалната пицата.</li>
	<li>Вторият човек е взел \(2\%\) от останалото, т.е. \(\dfrac{2}{100}*\dfrac{99}{100}\), като след него останали  \(\dfrac{99}{100} - \dfrac{2}{100}*\dfrac{99}{100} = \dfrac{99}{100}*\dfrac{98}{100} \) части от пицата.</li>
	<li>Третият човек е взел \(3\%\) от \(\dfrac{99}{100}*\dfrac{98}{100}\) или \(\dfrac{3}{100}*\dfrac{99}{100}*\dfrac{98}{100}\), оставяйки след себе си \(\dfrac{99}{100}*\dfrac{98}{100}*\dfrac{97}{100}\)</li>
	<li style="list-style-type: none;">...</li>
	<li>n-тия по ред човек е взел \(\dfrac{99}{100}*\dfrac{98}{100}* \cdots * \dfrac{99-(n-2)}{100}*\dfrac{n}{100} = \dfrac{99!}{(99-(n-1)))!}*\dfrac{n}{100^n} = \dfrac{99!}{(100-n)!}*\dfrac{n}{100^n}  \)</li>
	<li>n+1 по ред човек е взел \( \dfrac{99!}{(100-n-1)!}*\dfrac{n+1}{100^{n+1}}  \)</li>
	<li style="list-style-type: none;">...</li>
</ul>
Тъй като е сложно да се изследват тези изрази поотделно, можем да разгледаме съотношението между количеството пица, което n+1 по ред човек е взел ( \(P_{n+1}\) ), спрямо това, което n-тият човек е взел ( \(P_{n}\) ):<br>
\( \dfrac{P_{n+1}}{P_{n}} = \dfrac{ \dfrac{99!}{(100-n-1)!}*\dfrac{n+1}{100^{n+1}}  }{ \dfrac{99!}{(100-n)!}*\dfrac{n}{100^n} } = \dfrac{99!}{(100-n-1)!}*\dfrac{n+1}{100^{n+1}} * \dfrac{(100-n)!}{99!}*\dfrac{100^n}{n} = \dfrac{100-n}{100}* \dfrac{n+1}{n} \) <br>

\(P_{n+1} \gt P_{n}\)  тогава и само тогава, когато \( \dfrac{P_{n+1}}{P_{n}} \gt 1 \)<br>
Следователно парчетата пица ще растат дотогава, докато \( \dfrac{(100-n)(n+1)}{100n} \gt 1 \)
\( \iff (100-n)(n+1) \gt 100n \iff 100 \gt n^2+n \).<br>
Тъй като \(n\) е цяло число, можем лесно да проверим, че неравенството е изпълнено, когато \(1 \le n \le 9\).<br>
Когато \(n=9\) знаем, че  \( \dfrac{P_{10}}{P_9} \gt 1 \), т.е. до десетия по ред човек парчетата пица се увеличават, след което започват да намаляват.<br>
Следователно <b>10-тият по ред човек е получил най-голямото парче пица</b>, което представлява \( \dfrac{99!}{90!} * \dfrac{10}{100^{10}} \approx 6.28\% \) от пицата.
		</div>
	</div>
	<h3 id="week3,question3">Неравенства</h3>
	<p>Целите положителни числата \(a\) и \(b\) са такива, че \( \dfrac{2021}{2022} \lt \dfrac{a}{b} \lt \dfrac{2022}{2023} \) <br>
Коя е най-малката възможна стойност за \(b\)?</p>
	<div>
		<input type="checkbox" id=solution33><label class="explanationbutton" for=solution33><span>Обяснение</span></label>
		<div class="explanation">
<h4 id="week3,solution33,ProgramSolution">Решението на програмиста:</h4>
Едно интуитивно решение с програма би могло да се реализира чрез последователното обхождане на целите числа като стойност на \(b\) и съответно проверка дали съществува цяло число за \(a\), такова че неравенствата да са изпълнени.<br>
Какви са ограниченията за \(a\) при конкретна стойност на \(b\)?<br>
(1)  \( \dfrac{2021}{2022} \lt \dfrac{a}{b} \iff a \gt \dfrac{2021*b}{2022} \) и това е долна граница за \(a\), която можем да разпишем малко по-подробно по следния начин:
<ul>
	<li>Ако \( \dfrac{2021*b}{2022} \) е цяло число, то \( a \ge \dfrac{2021*b}{2022}+1\)</li>
	<li>Ако \( \dfrac{2021*b}{2022} \) не е цяло число, то \( a \ge \left \lceil \dfrac{2021*b}{2022} \right \rceil \)</li>
</ul>
(2)  \( \dfrac{a}{b} \lt \dfrac{2022}{2023} \iff a \lt \dfrac{2022*b}{2023} \), като получаваме неравенство, даващо ни горна граница за \(a\):
<ul>
	<li>Ако \( \dfrac{2022*b}{2023}\) е цяло число, то \( a \le \dfrac{2022*b}{2023} -1\)</li>
	<li>Ако \( \dfrac{2022*b}{2023}\) не е цяло число, то \( a \le \left \lfloor \dfrac{2022*b}{2023} \right \rfloor\)</li>
</ul>
Използвайки целочислено деление в Java, тези ограничения могат да се имплементират като: 
<pre><code>public long getLowerBound () {
	return 2021*b / 2022 + 1;
}

public long getUpperBound () {
	if (2022 * b % 2023 == 0) {
		return 2022 * b / 2023 - 1;
	} else {
		return 2022 * b / 2023;
	}
}
</code></pre><br>
<a href="https://github.com/saplabsbg/technoteaser/blob/master/src/saptechnoteaser2022/week3/LowestDenominatorInequality.java" target=_blank>Примерен Java код</a><br><br>

<b>Отговор: 4045</b><br><br>

<h4 id="week3,solution33,MathSolution">Решението на математика:</h4>
Тъй като търсим гранична стойност, първата ни цел трябва да бъде преобразуване на неравенствата от строги в нестроги такива, тъй като именно равенството в едно нестрого неравенство дефинира граничния случай.<br>
Преходът от строго към нестрого неравенство е труден, когато работим с рационални (дробни) числа. Затова първата цел ще бъде чрез еквивалентни преобразувания да достигнем до неравенства на цели числа.<br>
Ако обърнем местата на числителите и знаменателите (вземайки реципрочните стойности) и обърнем посоката на неравенствата, ще получим идентични неравенства, т.е. <br>
\( \dfrac{2021}{2022} \lt \dfrac{a}{b} \lt \dfrac{2022}{2023} \iff \dfrac{2022}{2021} \gt \dfrac{b}{a} \gt \dfrac{2023}{2022} \iff 1+\dfrac{1}{2021} \gt \dfrac{b}{a} \gt 1+\dfrac{1}{2022}\)<br>
\( \iff \dfrac{1}{2021} \gt \dfrac{b}{a}-1 \gt \dfrac{1}{2022} \iff \dfrac{1}{2021} \gt \dfrac{b-a}{a} \gt \dfrac{1}{2022} \)<br>
\( \iff 2021 \lt \dfrac{a}{b-a} \lt 2022 \iff 2021(b-a) \lt a \lt 2022(b-a)\)<br>
Тъй като за целите числа знаем, че \( x \lt y \) тогава и само тогава, когато \( x+1 \le y \) и аналогично \( x \gt y \iff x \ge y-1\), то <br>
\(  2021(b-a) \lt a \lt 2022(b-a) \iff 2021(b-a) + 1 \le a \le (b-a)2022 - 1 \), т.е.<br> 
\( 2021(b-a) +1 \le 2022(b-a)-1 \) откъдето получаваме \( b-a \ge 2\).<br>
Вземайки граничния случай, при който \( b-a = 2\), или \( a = b-2\) и замествайки в неравенството по-горе, получаваме<br>
\( 2021*2+1 \le b-2 \le 2022*2-1\), където първото неравенство ни дава точно минималната стойност за \(b\):<br>
\(  2021*2+1 \le b-2 \iff b \ge 2021*2+3 \iff b \ge 4045 \) <br>
Лесно можем да съобразим, че когато \( b-a \gt 2\), примерно 3, то възможните стойности за \(b\) ще са по-големи, както и да проверим, че при \(a=4043\) и \(b=4045\) неравенствата са изпълнени, получавайки най-малка възможна стойност за \(b\) съответно <b>4045</b>.
<hr>
<h4>За малките числа</h4><br>
Колко малко може да бъде едно число?<br>
Всички знаем, че няма граница за това. Можем да направим аналогия с безкрайността, с която сме свикнали да работим като понятие и за която знаем, че е по-голяма от всяко конкретно число. По същия начин в домейна на положителните реални числа "безкрайно малкото число" е по-малко от всяко конкретно число, независимо колко малко е то.<br>
Безкрайно малките числа (<a href="https://en.wikipedia.org/wiki/Infinitesimal" target=_blank>Infinitesimal numbers</a>) не са част от стандартнaта бройна система на реалните числа, но намират приложение в други бройни системи, към които обикновено са добавени както безкрайността, така и безкрайно малкото като величини.			
		</div>
	</div>
</div>
<!-- end of week 3-->
<input type="checkbox" id=week4Toggle>
<label for=week4Toggle class="week">
<h2 id=week4>Седмица №4 <span></span></h2>
</label>	
<div>
	<h3 id="week4,question1">Турнир</h3>
	<p>В първия кръг на турнир по шах всеки участник е изиграл точно една игра с всески друг. Във всяка игра спечелилият е получил 1 точка, загубилият - 0 точки, а когато играта е завършвала с реми, двамата играчи са получавали по половин точка.<br>
За втория кръг не се класирали 10-те участника с най-малко точки.<br>
Оказало се, че всеки участник в първи кръг е спечелил половината си точки от игрите си спрямо отпадналите. Това важало включително и за отпадналите 10-ма, т.е. всеки един от тях е спечелил половината си точки от игрите си спрямо останалите 9-ма.<br>
Колко шахматисти са участвали в първи кръг?</p>
	<div>
		<input type="checkbox" id=solution41><label class="explanationbutton" for=solution41><span>Обяснение</span></label>
		<div class="explanation">
Очаквайте скоро!
		</div>
	</div>
	<h3 id="week4,question2">Везна с тежести</h3>
	<p>Търговец е закупил нова везна, която показва дали от двете страни е поставено едно и също тегло или не. За претегляне на конкретното тегло стока в цяло число кг, обаче, търговецът трябва да ползва тежести (също в цяло число кг), чието тегло той знае предварително.<br>Какъв е най-малкият брой тежести, с които трябва да разполага търговецът, за да може да измери всяко цяло число килограми от 1 до 13 включително, ако търговецът може да поставя своите тежести и от двете страни на везната?<br> Пример: ако допуснем, че търговецът разполага с тежест от 3 кг и с тежест от 5 кг, то той може да ги постави от различните страни на везната и по този начин да измери 2 кг стока. Може също така да ги постави от една и съща страна, измервайки стока за 8 кг, т.е. с тези две тежести той може да измери 2, 3, 5 и 8 кг стока.</p>
	<div>
		<input type="checkbox" id=solution42><label class="explanationbutton" for=solution42><span>Обяснение</span></label>
		<div class="explanation">
Очаквайте скоро!
		</div>
	</div>
	<h3 id="week4,question3">Изчисли функцията</h3>
	<p>Фунцията \(f(x) : \mathbb{R} \to \mathbb{R} \) е дефинирана за реалните числа от затворения интервал [0, 1] и има следните свойства:
<ul>
	<li>\(f\left(\dfrac{x}{3}\right) = \dfrac{1}{2}f(x)\)</li>
	<li>\(f(1-x) = 1 - f(x)\)</li>
	<li>Функцията е ненамаляваща, т.е. ако \(x_2 \gt x_1\), то \(f(x_2) \ge f(x_1)\) </li>
</ul>
Да се намери \(f\left(\dfrac{2021}{2022}\right) = \text{?} \)</p>
	<div>
		<input type="checkbox" id=solution43><label class="explanationbutton" for=solution43><span>Обяснение</span></label>
		<div class="explanation">
Очаквайте скоро!
		</div>
	</div>
</div>
<!-- end of week 4-->
<!--
<input type="checkbox" id=week5Toggle>
<label for=week5Toggle class="week">
<h2 id=week5>Седмица №5<span></span></h2>
</label>	
<div>
	<h3 id="week5,question1">week5,question1</h3>
	<p> Q 5.1 </p>
	<div>
		<input type="checkbox" id=solution51><label class="explanationbutton" for=solution51><span>Обяснение</span></label>
		<div class="explanation">
	<h4 id="week5,solution51,ProgramSolution">Решението на програмиста:</h4>
Q 5.1 Solution
		</div> 
	</div>
	<h3 id="week5,question2">week5,question2</h3>
	<p> Q 5.2</p>
	<div>
		<input type="checkbox" id=solution52><label class="explanationbutton" for=solution52><span>Обяснение</span></label>
		<div class="explanation">
Q 5.2 Solution
		</div> 
	</div>
	<h3 id="week5,question3">week5,question3</h3>
	<p> Q5.3 </p>
	<div>
		<input type="checkbox" id=solution53><label class="explanationbutton" for=solution53><span>Обяснение</span></label>
		<div class="explanation">
Q 5.3 Solution
		</div> 
	</div>
</div>
-->
<!-- end of week 5-->
<!--
<input type="checkbox" id=week6Toggle>
<label for=week6Toggle class="week">
<h2 id=week6>Седмица №6<span></span></h2>
</label>	
<div>
	<h3 id="week6,question1">week6,question1</h3>
	<p> Q 6.1 </p>
	<div>
		<input type="checkbox" id=solution61><label class="explanationbutton" for=solution61><span>Обяснение</span></label>
		<div class="explanation">
Q 6.1 Solution
		</div>
	</div>
	<h3 id="week6,question2">week6,question2</h3>
	<p>Q 6.2</p>
	<div>
		<input type="checkbox" id=solution62><label class="explanationbutton" for=solution62><span>Обяснение</span></label>
		<div class="explanation">
Q 6.2 Solution
		</div>
	</div>
	<h3 id="week6,question3">week6,question3</h3>
	<p>Q 6.3 </p>
	<div>
		<input type="checkbox" id=solution63><label class="explanationbutton" for=solution63><span>Обяснение</span></label>
		<div class="explanation">
Q 6.3 Solution
		</div>
	</div>
</div>
-->
<!-- end of week 6-->
<script>
function hashChange() {
	if (window.location.hash) {
		var hashID = window.location.hash.substr(1);
        var hashArr = hashID.split(",");
        for (i in hashArr) {
			var obj = document.getElementById(hashArr[i] + (i==0 ? "Toggle" : ""));
			if (obj) {obj.checked = true;}
		}
	}
}
window.onhashchange = hashChange;
window.onload = hashChange;
hashChange();
</script>
<br>
<div class="footer">
<a href="https://www.sap.com/about/careers/who-we-are/locations/sap-labs-bulgaria.html" target="_blank"><p class="footer-element">Виж повече за развойния център на SAP в София</p></a><a href="https://www.sap.com/about/careers/who-we-are/locations/sap-labs-bulgaria.html" target="_blank"><img class="footer-image" src="https://saplabsbg.github.io/technoteaser/docs/images/sap_logo.png" width="40" height="20"></a> <a href="https://www.facebook.com/saplabsbg" target="_blank"><p class="footer-element">Харесай страницата ни във Facebook</p></a><a href="https://www.facebook.com/saplabsbg" target="_blank"><img class="footer-image" src="https://saplabsbg.github.io/technoteaser/docs/images/fb_logo.png" width="30" height="20"></a> <a href="https://jobs.sap.com/search/?q=&locationsearch=bulgaria" target="_blank"><p class="footer-element">Разгледай отворените позиции при нас</p></a><a href="https://jobs.sap.com/search/?q=&locationsearch=bulgaria" target="_blank"><img class="footer-image" src="https://saplabsbg.github.io/technoteaser/docs/images/network.png" width="25" height="25"></a>
</div>

{:/}
