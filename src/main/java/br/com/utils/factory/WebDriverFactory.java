package br.com.utils.factory;

import java.io.File;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import br.com.utils.ui.io.SelecionaArquivoUI;


public class WebDriverFactory {

    public static WebDriver getFirefoxDriver() throws Exception {
        try {
            FirefoxDriver driver = new FirefoxDriver();
            return driver;
        } catch (WebDriverException e) {
            try {
                JOptionPane.showMessageDialog(
                                null,
                                "Url para FireFox não encontrado.\nSelecione o caminho para o Arquivo \"firefox.exe\":");
                File pathToBinary = new SelecionaArquivoUI().abreArquivo("exe");
                if (!pathToBinary.getCanonicalPath().contains("firefox.exe")) {
                    throw new WebDriverException();
                }
                FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                FirefoxDriver driver = new FirefoxDriver(ffBinary,
                                firefoxProfile);
                return driver;
            } catch (WebDriverException e1) {
                JOptionPane.showMessageDialog(
                                null,
                                "Selecione o Arquivo \"firefox.exe\" corretamente\n\n" + e1
                                                .getMessage());
                throw new WebDriverException(e1);
            }
        }
    }
}
