package org.scoula.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class UploadFiles {

    public static String upload(String baseDir, MultipartFile part) throws IOException {

        File base = new File(baseDir);

        // 디렉터리가 없으면 생성
        if (!base.exists()) {
            base.mkdirs();
        }

        // 원본 파일명
        String filename = part.getOriginalFilename();

        // 저장 파일명 생성
        File dest = new File(baseDir,
                UploadFileName.getUinqueName(filename));

        // 파일 저장
        part.transferTo(dest);

        // 저장 경로 반환
        return dest.getPath();
    }

    // size Long -> 문자열로 포맷팅해서 보여주는 메서드
    public static String getFormatSize(Long size) {
        if (size <= 0)
            return "0";
        final String[] units = new String[] { "Bytes", "KB", "MB", "GB", "TB" };
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public static void download(HttpServletResponse response, File file, String orgName) throws IOException {
        response.setContentType("application/download"); // 응답으로 보내는 데이터는 다운로드용 파일이다.
        // incline일 때는 image/png로 해줘야 파일명과 확장자가 잘 붙음.
        
        response.setContentLength((int)file.length());
        
        String filename = URLEncoder.encode(orgName, "UTF-8"); // 인코딩

        // Content-disposition: 파일 처리 방식을 지정하는 HTTP Header(inline/attachment) inline은 웹에서 바로 띄움
        response.setHeader("Content-Disposition", "attachment;filename=\"" + filename+"\"");

        try(OutputStream os = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os)){

            Files.copy(Paths.get(file.getPath()), bos);
        }
    }
}