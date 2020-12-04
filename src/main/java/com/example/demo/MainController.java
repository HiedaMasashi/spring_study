package com.example.demo;
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

}
