// Copyright 2017 Sebastian Kuerten
//
// This file is part of swing-utils.
//
// swing-utils is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// swing-utils is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with swing-utils. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.swing.util;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class ImageLoader
{

	static final Logger logger = LoggerFactory.getLogger(ImageLoader.class);

	/**
	 * Load an image from the given filename. The file-resource will be resolved
	 * by using the classloader. {@link ImageIO#read(InputStream)} will be used
	 * to decode the image.
	 * 
	 * @param filename
	 *            the resource to load
	 * @return the Icon loaded or null
	 */
	public static Icon load(String filename)
	{
		if (filename == null) {
			return null;
		}

		// try ImageIO
		BufferedImage bi = null;
		try (InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(filename)) {
			bi = ImageIO.read(is);
		} catch (Exception e) {
			logger.debug(String.format("unable to load icon: '%s'", filename),
					e);
		}
		if (bi != null) {
			return new BufferedImageIcon(bi);
		}

		// unable to load image
		return null;
	}

}
