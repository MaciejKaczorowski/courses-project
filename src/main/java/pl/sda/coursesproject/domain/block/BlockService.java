package pl.sda.coursesproject.domain.block;

import org.springframework.stereotype.Service;
import pl.sda.coursesproject.domain.lesson.Lesson;
import pl.sda.coursesproject.domain.lesson.LessonRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlockService {

    private final BlockRepository blockRepository;
    private final LessonRepository lessonRepository;

    public BlockService(BlockRepository blockRepository, LessonRepository lessonRepository) {
        this.blockRepository = blockRepository;
        this.lessonRepository = lessonRepository;
    }

    public Block addBlock (Block block) {
        return blockRepository.save(block);
    }

    public Block getBlockByName (String name) {
        return blockRepository.findBlockByName(name);
    }

    public Block getBlockById(Long id) {
        return blockRepository.getById(id);
    }

    @Transactional
    public Block addLessonToBlock (Long blockId, Long lessonId) {
        Block block = blockRepository.getById(blockId);
        Lesson lesson = lessonRepository.getById(lessonId);
        List<Lesson> lessons = block.getLessons();
        lessons.add(lesson);
        block.setLessons(lessons);
        return blockRepository.save(block);
    }

    public List<Block> displayAllBlocks () {
        return blockRepository.findAll();
    }

    public void removeBlock (Long id) {
        blockRepository.delete(blockRepository.getById(id));

    }
}
