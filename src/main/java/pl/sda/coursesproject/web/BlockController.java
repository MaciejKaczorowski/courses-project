package pl.sda.coursesproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.coursesproject.domain.block.Block;
import pl.sda.coursesproject.domain.block.BlockRepository;
import pl.sda.coursesproject.domain.block.BlockService;
import pl.sda.coursesproject.domain.course.Course;
import pl.sda.coursesproject.domain.lesson.LessonRepository;
import pl.sda.coursesproject.domain.lesson.LessonService;

import java.util.List;

@Controller
@RequestMapping("/blocks")
public class BlockController {

   private final BlockService blockService;
   private final LessonService lessonService;

    public BlockController(BlockService blockService, LessonService lessonService) {
        this.blockService = blockService;
        this.lessonService = lessonService;
    }

    @GetMapping
    public String  blockList (Model model) {
        List<Block> blockList = blockService.displayAllBlocks();
        model.addAttribute("blocks", blockList);
        return "blockList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blockService.removeBlock(id);
        return "redirect:/courses";
    }


    @GetMapping("/add")
    public String addCourse (Model model) {
        model.addAttribute("course", new Course());
        return "courseRegistrationForm";
    }
}
