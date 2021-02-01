#!/bin/sh
#
# Copyright (c) 2021 GreatApps4you LLC
# This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
# https://www.gnu.org/licenses/gpl-3.0.txt
# https://greatapps4you.us
# CSSML NDSMD VRS + SNMV SMQL IVB
#

dir=$(dirname "$0")
java -cp "$dir/h2-1.4.199.jar:$H2DRIVERS:$CLASSPATH" org.h2.tools.Console "$@"
