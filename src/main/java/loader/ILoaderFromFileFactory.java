package loader;

public class ILoaderFromFileFactory {
	
	public enum FileTypeEnum{DELIMITED};
	
	public ILoaderFromFile createLoadFromFile(FileTypeEnum type) {
		if (type == FileTypeEnum.DELIMITED) {
			return new LoaderFromFileDelimited();
		}
		
		return null;
	}
}
