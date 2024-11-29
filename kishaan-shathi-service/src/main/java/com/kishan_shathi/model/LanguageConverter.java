package com.kishan_shathi.model;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;


public class LanguageConverter {
	public static void main(String[] args) {
        // Initialize the Translate service
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        // Text to be translated
        String textToTranslate = "Hello, how are you?";

        // Translate the text from English to Hindi
        Translation translation = translate.translate(
            textToTranslate,
            Translate.TranslateOption.sourceLanguage("en"),
            Translate.TranslateOption.targetLanguage("hi")
        );

        // Output the translated text
        System.out.println("Translated Text: " + translation.getTranslatedText());
    }
}
