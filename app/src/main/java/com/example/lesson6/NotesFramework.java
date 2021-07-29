package com.example.lesson6;

import java.util.ArrayList;
import java.util.List;

public class NotesFramework {

    public static List<Note> getListOfNotes() {
        List<Note> notes = new ArrayList<>();

        notes.add(
                new Note(
                        "Купить продукты",
                        "Необходимо купить: овощи, фрукты, хлеб и т.д."
                )
        );

        notes.add(
                new Note(
                        "Изучить паттерны проектирования",
                        "Для этого необходимо купить и прочитать книгу с сайта https://refactoring.guru/ru"
                )
        );

        notes.add(
                new Note(
                        "Сделать домашнее задание №6",
                        "Нужно прочитать методичку для закрепления видео материала."
                )
        );

        notes.add(
                new Note(
                        "Расписание занятий GeekBrains",
                        "Занятия проходят в среду и воскресенье."
                )
        );

        return notes;
    }
}
