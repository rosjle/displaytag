/**
 * Copyright (C) 2002-2014 Fabrizio Giustina, the Displaytag team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.displaytag.jsptests;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.TableRow;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;

import org.displaytag.test.DisplaytagCase;
import org.junit.Assert;
import org.junit.Test;


/**
 * Test for DISPL-110 - Ability to highlight selected table row.
 *
 * @author Fabrizio Giustina
 * @version $Id$
 */
public class Displ110Test extends DisplaytagCase
{

    /**
     * Gets the jsp name.
     *
     * @return the jsp name
     * @see org.displaytag.test.DisplaytagCase#getJspName()
     */
    @Override
    public String getJspName()
    {
        return "DISPL-110.jsp";
    }

    /**
     *
     * @throws Exception any axception thrown during test.
     */
    @Override
    @Test
    public void doTest() throws Exception
    {

        WebRequest request = new GetMethodWebRequest(getJspUrl(getJspName()));

        WebResponse response = this.runner.getResponse(request);

        if (this.log.isDebugEnabled())
        {
            this.log.debug(response.getText());
        }

        WebTable[] tables = response.getTables();
        Assert.assertEquals("Wrong number of tables.", 1, tables.length);

        Assert.assertEquals("Wrong number of columns.", 2, tables[0].getColumnCount());
        Assert.assertEquals("Wrong number of rows.", 3, tables[0].getRowCount()); // 2 plus header

        TableRow[] rows = tables[0].getRows();

        Assert.assertEquals("Wrong id for row 1", "idcamel0", rows[1].getID());
        Assert.assertEquals("Wrong id for row 2", "idcamel1", rows[2].getID());

        Assert.assertEquals("Wrong class for row 1", "odd classcamel0", rows[1].getClassName());
        Assert.assertEquals("Wrong class for row 2", "even classcamel1", rows[2].getClassName());

    }
}