package ru.thecoolkuid.main.log;

import java.io.File;
/**
 * Отправка на  FTP сервер.
 * @author coolkuid
 *
 */
public class SendByFTP {
	protected static String username , pass , Adress;
	public static boolean sendDuringError;
	/**
	 * Устанавливает данные FTP аккаунта
	 * @param usern	Имя пользователя.
	 * @param password	Пароль.
	 * @param adres	IP адрес или доменное имя..
	 */
	public static void setFTPProps(String usern, String password, String adres){
		username = usern;
		pass = password;
		Adress = adres;
	}
	/**
	 *Осуществляет загрузку на FTP сервер.
	 * @param directory	директория, в которую будет загружен файл, не забывайте закрыть директорию! test/log/,а не test/log
	 * Если необходимо загрузить в корень, оставте поле пустым.
	 * @param file Файл, который будет загружен.
	 * @throws Exception
	 */
	public static void FTPUpload(String directory, File file){
		try{
		ru.thecoolkuid.main.send.FTPUpload.FTPup(username, pass, Adress, directory, file.getName());
		}catch(Exception e){
			
		}
	}
	/**
	 *Осуществляет загрузку на FTP сервер.
	 * @param directory	директория, в которую будет загружен файл, не забывайте закрыть директорию! test/log/,а не test/log
	 * Если необходимо загрузить в корень, оставте поле пустым.
	 * @param file Файл, который будет загружен.
	 * @throws Exception
	 */
	public static void FTPUpload(String directory, String file){
		ru.thecoolkuid.main.send.FTPUpload.FTPup(username, pass, Adress, directory, file);
	}
	/**
	 * Включение отправки log файла на FTP сервер при ошибках.
	 * @param x Параметр включения.
	 * @return
	 */
	public static boolean sendDuringError(boolean x){
		sendDuringError = x;
		return x;
	}
}
