package com.salesianos.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.spring.model.Vendedores;
import com.salesianos.spring.model.Marcas;
import com.salesianos.spring.model.Coches;
import com.salesianos.spring.repository.MarcasRepository;
import com.salesianos.spring.repository.VendedoresRepository;
import com.salesianos.spring.repository.CochesRepository;

//Falta ser refactorizado
@Controller
public class ConcesionarioController {
 
    @Autowired
    private VendedoresRepository hr;

    @Autowired
    private MarcasRepository sr;
 
    @GetMapping("/")
    public String listaUsuarios(Model model){
    	model.addAttribute("users", hr.findAll());
        model.addAttribute("spells", sr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/asc")
    public String listaUsuariosAsc(Model model){
    	model.addAttribute("users", hr.findByOrderByFullnameAsc());
        model.addAttribute("spells", sr.findAll());
        model.addAttribute("type", "asc");
        return "index";
    }
    
    @GetMapping("/desc")
    public String listaUsuariosDesc(Model model){
    	model.addAttribute("users", hr.findByOrderByFullnameDesc());
        model.addAttribute("spells", sr.findAll());
        model.addAttribute("type", "desc");
        return "index";
    }
    
    @GetMapping("/spells")
    public String listaHechizos(Model model){
    	model.addAttribute("spells", sr.findAll());
        return "hechizos";
    }
    
    @GetMapping("/verHechizo/{id}")
    public String verHechizo(@PathVariable long id, Model model){
    	Optional<Spell> sp = sr.findById(id);
    	model.addAttribute("spell", sp.get());
        return "verHechizo";
    }
    
    @GetMapping("/buscar")
    public String buscarAlPorHe(String nomHechizo, Model model) {
    	model.addAttribute("alPorHe", sr.alumnosPorHechizo(nomHechizo.toUpperCase()));
		return "alumnosPorHechizo";
    }
 
    @GetMapping("/add")
    public String nuevo(Model model){
    	model.addAttribute("user", new Student());
    	model.addAttribute("spells", sr.findAll());
        return "nuevo";
    }
    
    @GetMapping("/addSpell")
    public String nuevoHechizo(Model model){
    	model.addAttribute("spell", new Spell());
        return "nuevoHechizo";
    }
    
    @PostMapping("/crear")
    public String crear(Student student,
            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/add";
        }else{
        	hr.save(student);
        	model.addAttribute("users", hr.findAll());
            model.addAttribute("spells", sr.findAll());
            return "redirect:/";
        }
    }
    
    @PostMapping("/crearHechizo")
    public String crearHechizo(Spell spell,
            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/addSpell";
        }else{
        	sr.save(spell);
        	model.addAttribute("spells", sr.findAll());
            return "redirect:/spells";
        }
    }
    
    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable long id, Model model){
    	Optional<Student> bl = hr.findById(id);
    	hr.delete(bl.get());
        model.addAttribute("users", hr.findAll());
        model.addAttribute("spells", sr.findAll());
        return "redirect:/";
    }
    
    @GetMapping("/borrarHechizo/{id}")
    public String borrarHechizo(@PathVariable long id, Model model){
    	List<Student> sl = hr.findAll();
    	for (Student st : sl) {
    		if (st.getSpellknown() == id) st.setSpellknown(0);
    		hr.save(st);
    	}
    	Optional<Spell> sp = sr.findById(id);
    	sr.delete(sp.get());
        model.addAttribute("spells", sr.findAll());
        return "redirect:/spells";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable long id, Model model){
    	Optional<Student> st = hr.findById(id);
    	model.addAttribute("student", st.get());
    	model.addAttribute("spells", sr.findAll());
        return "editar";
    }
    
    @GetMapping("/editarHechizo/{id}")
    public String editarHechizo(@PathVariable long id, Model model){
    	Optional<Spell> sp = sr.findById(id);
    	model.addAttribute("spell", sp.get());
        return "editarHechizo";
    }
     
    @PostMapping("/actualizar")
    public String actualizar(Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
        	model.addAttribute("users", hr.findAll());
            model.addAttribute("spells", sr.findAll());
        return "redirect:/";
        }
        Optional<Student> sl = hr.findById(student.getIdstudent());
        Student user = sl.get();
        user.setFullname(student.getFullname());
        user.setDni(student.getDni());
        user.setEmail(student.getEmail());
        user.setDni(student.getDni());
        user.setIsmuggle(student.getIsmuggle());
        user.setMatriculationdate(student.getMatriculationdate());
        user.setBirthdate(student.getBirthdate());
        user.setGender(student.getGender());
        user.setSpellknown(student.getSpellknown());
        hr.save(user);
        model.addAttribute("users", hr.findAll());
        model.addAttribute("spells", sr.findAll());
        return "redirect:/";
    }
    
    @PostMapping("/actualizarHechizo")
    public String actualizarHechizo(Spell spell, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("spells", sr.findAll());
            return "redirect:/spells";
        }
        Optional<Spell> sp = sr.findById(spell.getIdspell());
        Spell newSpell = sp.get();
        newSpell.setSpellname(spell.getSpellname());
        newSpell.setSpelldescription(spell.getSpelldescription());
        newSpell.setType(spell.getType());
        newSpell.setLevel(spell.getLevel());
        newSpell.setDamage(spell.getDamage());
        newSpell.setIslethal(spell.getIslethal());
        sr.save(newSpell);
        model.addAttribute("spells", sr.findAll());
        return "redirect:/spells";
    }
    
    @GetMapping("/students/{id}")
    public String estudiantePorId(@PathVariable long id, Model model){
    	model.addAttribute("users", hr.findByID(id));
        model.addAttribute("spells", sr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/year/{year}")
    public String estudiantePorAño(@PathVariable int year, Model model){
    	model.addAttribute("users", hr.findByYear(year));
        model.addAttribute("spells", sr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/birthyear/{year}")
    public String estudiantePorAñoNacimiento(@PathVariable int year, Model model){
    	model.addAttribute("users", hr.findByBirthYear(year));
        model.addAttribute("spells", sr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/spells/{id}")
    public String hechizoPorId(@PathVariable long id, Model model){
    	model.addAttribute("spells", sr.findByID(id));
        return "hechizos";
    }
    
    @GetMapping("/power/{dmg}")
    public String hechizoPorPoder(@PathVariable int dmg, Model model){
    	model.addAttribute("spells", sr.findByDmg(dmg));
        return "hechizos";
    }
    
    @GetMapping("/level/{lvl}")
    public String hechizoPorNivel(@PathVariable int lvl, Model model){
    	model.addAttribute("spells", sr.findByLevel(lvl));
        return "hechizos";
    }
}