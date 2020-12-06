package com.example.demo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

@RequestMapping(value="/", method=RequestMethod.GET)
public ModelAndView indexGet(ModelAndView mv){
mv.addObject("name", "名前がここに入ります");
mv.addObject("age", "年齢がここに入ります");
mv.addObject("height", "身長がここに入ります");
mv.setViewName("index");
return mv;
}

@RequestMapping(value="/", method=RequestMethod.POST)
public ModelAndView indexPost(ModelAndView mv, @RequestParam("nameVal")String
name,
@RequestParam("ageVal")int age, @RequestParam("heightVal")String height, 
@RequestParam("birthPlaceVal")String birthPlace){
mv.addObject("name", name);
mv.addObject("age", age-3);
mv.addObject("height", height);
mv.addObject("birthPlace", birthPlace);
mv.setViewName("index");
return mv;
}

@RequestMapping(value="/kaijo", method=RequestMethod.GET)
public ModelAndView indexGet1(ModelAndView mv){
mv.addObject("number", "階乗の計算をします。");

mv.setViewName("kaijo");
return mv;
}

@RequestMapping(value="/kaijo", method=RequestMethod.POST)
public ModelAndView indexPost1(ModelAndView mv, @RequestParam("numberVal")int
number){

int answer = 1;
for(int i = 1;i<= number;i++) {
	answer = answer * i ;
}
	
mv.addObject("number", number+"の階乗は"+answer+"です。");
mv.setViewName("kaijo");
return mv;
}

@RequestMapping(value="/if", method=RequestMethod.GET)
public ModelAndView ifGet(ModelAndView mv) {
mv.addObject("suzuki",5);
mv.setViewName("if");
return mv;
}

@RequestMapping(value="/if", method=RequestMethod.POST)
public ModelAndView ifPost(ModelAndView mv) {
mv.addObject("suzuki","off");
mv.setViewName("if");
return mv;
}

@RequestMapping("/{name}")
public ModelAndView index(@PathVariable String name, ModelAndView mv) {
	mv.addObject("name", name);
	mv.setViewName("index");
	return mv;
}

@RequestMapping("/name/{namae}/age/{age}")
public ModelAndView index(@PathVariable String namae, @PathVariable String age, ModelAndView mv) {
	mv.addObject("name", namae);
	mv.addObject("age", age);
	mv.setViewName("index");
	return mv;
}

@RequestMapping(value="/pcc", method=RequestMethod.GET)
public ModelAndView pccGet(ModelAndView mv) {
mv.addObject("totalValue","129,800円");
mv.setViewName("PersonalComputerCustom");
return mv;
}

@RequestMapping(value="/pcc", method=RequestMethod.POST)
public ModelAndView pccPost(ModelAndView mv, @RequestParam("osRadio")int osC,
@RequestParam("cpuRadio")int cpuC, @RequestParam("memoryRadio")int memoryC, 
@RequestParam("hddRadio")int hddC) {

	System.out.println(osC+cpuC+memoryC+hddC);
	
mv.addObject("totalValue",129800+osC+cpuC+memoryC+hddC+"円");
mv.setViewName("PersonalComputerCustom");
return mv;
}

}
